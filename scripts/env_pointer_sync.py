#!/usr/bin/env python3
"""
Sincronización del ambiente por punteros (last_commits.json).

Jerarquía fija: core → capas (en orden) → módulos (en orden).
- Primera ejecución sin JSON: solo consulta HEAD de cada remoto y escribe last_commits.json (sin copiar árbol).
- Ejecuciones siguientes: si el SHA remoto difiere del guardado, aplica git diff entre ambos sobre repo-b.

Usado desde .github/workflows/update-env.yml; el token se pasa por entorno SYNC_TOKEN.
"""

from __future__ import annotations

import json
import os
import shutil
import subprocess
import sys
import tempfile
from pathlib import Path
from typing import Any

STATE_VERSION = 1


def run(
    cmd: list[str],
    cwd: Path | None = None,
    check: bool = True,
    capture: bool = False,
) -> subprocess.CompletedProcess:
    return subprocess.run(
        cmd,
        cwd=str(cwd) if cwd else None,
        check=check,
        text=True,
        capture_output=capture,
    )


def clone_url(token: str, slug: str) -> str:
    return f"https://{token}@github.com/{slug}.git"


def ls_remote_head_sha(token: str, slug: str) -> str:
    """SHA del commit al que apunta HEAD en el remoto (rama por defecto)."""
    url = clone_url(token, slug)
    cp = run(["git", "ls-remote", url, "HEAD"], capture=True, check=True)
    line = cp.stdout.strip().splitlines()
    if not line:
        raise RuntimeError(f"ls-remote vacío para {slug}")
    return line[0].split()[0]


def load_state(path: Path) -> dict[str, Any]:
    with open(path, encoding="utf-8") as f:
        return json.load(f)


def save_state(path: Path, data: dict[str, Any]) -> None:
    data["version"] = STATE_VERSION
    path.parent.mkdir(parents=True, exist_ok=True)
    with open(path, "w", encoding="utf-8") as f:
        json.dump(data, f, indent=2, sort_keys=False)
        f.write("\n")


def safe_rel_path(p: str) -> Path | None:
    norm = Path(p)
    if norm.is_absolute() or ".." in norm.parts:
        return None
    return norm


def deepen_until(workdir: Path, old_sha: str, max_rounds: int = 50) -> bool:
    for _ in range(max_rounds):
        r = run(
            ["git", "cat-file", "-e", f"{old_sha}^{{commit}}"],
            cwd=workdir,
            check=False,
        )
        if r.returncode == 0:
            return True
        r2 = run(
            ["git", "fetch", "--deepen=200", "origin"],
            cwd=workdir,
            check=False,
        )
        if r2.returncode != 0:
            break
    return False


def has_modules_subdir(workdir: Path) -> bool:
    return (workdir / "modules").is_dir()


def map_dest_path(repo_path: str, *, kind: str, workdir: Path) -> Path | None:
    sp = safe_rel_path(repo_path)
    if sp is None:
        return None
    if kind in ("core", "layer"):
        return sp
    if has_modules_subdir(workdir):
        parts = sp.parts
        if len(parts) >= 2 and parts[0] == "modules":
            return Path(*parts[1:])
        return sp
    return sp


def remove_path(dest_root: Path, rel: Path) -> None:
    d = dest_root / rel
    if d.is_file() or d.is_symlink():
        d.unlink()
    elif d.is_dir():
        shutil.rmtree(d, ignore_errors=True)


def full_sync_rsync(
    token: str,
    slug: str,
    dest_root: Path,
    *,
    kind: str,
) -> str:
    url = clone_url(token, slug)
    with tempfile.TemporaryDirectory(prefix="carnidem_full_") as td:
        wd = Path(td) / "w"
        run(["git", "clone", "--depth", "1", "--recursive", url, str(wd)], check=True)
        new_sha = run(
            ["git", "rev-parse", "HEAD"], cwd=wd, capture=True, check=True
        ).stdout.strip()
        if kind in ("core", "layer"):
            run(
                [
                    "rsync",
                    "-a",
                    f"{wd}/",
                    f"{dest_root}/",
                    "--exclude=.git",
                    "--exclude=.github",
                    "--exclude=.last_core_sync",
                    "--exclude=commit_message.txt",
                    "--exclude=.gitignore",
                    "--exclude=last_commits.json",
                ],
                check=True,
            )
        else:
            dest_root.mkdir(parents=True, exist_ok=True)
            if has_modules_subdir(wd):
                run(
                    [
                        "rsync",
                        "-a",
                        f"{wd}/modules/",
                        f"{dest_root}/",
                        "--exclude=.git",
                    ],
                    check=True,
                )
            else:
                run(
                    [
                        "rsync",
                        "-a",
                        f"{wd}/",
                        f"{dest_root}/",
                        "--exclude=.git",
                        "--exclude=.gitignore",
                        "--exclude=README.md",
                    ],
                    check=True,
                )
        return new_sha


def apply_delta(
    token: str,
    slug: str,
    old_sha: str,
    new_sha: str,
    dest_root: Path,
    *,
    kind: str,
    apply_deletes: bool,
) -> None:
    if old_sha == new_sha:
        return
    url = clone_url(token, slug)
    with tempfile.TemporaryDirectory(prefix="carnidem_delta_") as td:
        wd = Path(td) / "w"
        run(["git", "clone", "--depth", "1", "--recursive", url, str(wd)], check=True)
        head = run(
            ["git", "rev-parse", "HEAD"], cwd=wd, capture=True, check=True
        ).stdout.strip()
        if head != new_sha:
            # ls-remote y clone shallow deben coincidir con HEAD; si no, seguimos con head
            new_sha = head

        if not deepen_until(wd, old_sha):
            shutil.rmtree(wd, ignore_errors=True)
            full_sync_rsync(token, slug, dest_root, kind=kind)
            return

        diff = run(
            ["git", "diff", "--name-status", f"{old_sha}..{new_sha}"],
            cwd=wd,
            capture=True,
            check=True,
        ).stdout

        for line in diff.splitlines():
            if not line.strip():
                continue
            parts = line.split("\t")
            status = parts[0]
            if status.startswith("R"):
                old_p, new_p = parts[1], parts[2]
                ro = map_dest_path(old_p, kind=kind, workdir=wd)
                rn = map_dest_path(new_p, kind=kind, workdir=wd)
                if apply_deletes and ro:
                    remove_path(dest_root, ro)
                if rn and (wd / new_p).is_file():
                    dfile = dest_root / rn
                    dfile.parent.mkdir(parents=True, exist_ok=True)
                    shutil.copy2(wd / new_p, dfile)
                continue
            path = parts[1]
            rel = map_dest_path(path, kind=kind, workdir=wd)
            if rel is None:
                continue
            if status == "D":
                if apply_deletes:
                    remove_path(dest_root, rel)
                continue
            if status.startswith("A") or status.startswith("M"):
                sp = Path(path)
                if (wd / sp).is_file():
                    dfile = dest_root / rel
                    dfile.parent.mkdir(parents=True, exist_ok=True)
                    shutil.copy2(wd / sp, dfile)
                elif (wd / sp).is_dir():
                    dst = dest_root / rel
                    if dst.exists():
                        shutil.rmtree(dst)
                    shutil.copytree(wd / sp, dst)


def build_spec(core: str, layers: list[str], modules: list[str]) -> list[dict[str, str]]:
    out: list[dict[str, str]] = [{"type": "core", "repo": core}]
    for r in layers:
        if r.strip():
            out.append({"type": "layer", "repo": r.strip()})
    for r in modules:
        if r.strip():
            out.append({"type": "module", "repo": r.strip()})
    return out


def strip_submodule_ghost(repo_b: Path) -> None:
    run(["git", "rm", "--cached", "modules"], cwd=repo_b, check=False)
    gitmodules = repo_b / ".gitmodules"
    if gitmodules.is_file():
        gitmodules.unlink()


def sanitize_modules_modules(repo_b: Path) -> None:
    mods = repo_b / "modules"
    if not mods.is_dir():
        return
    for p in mods.rglob(".git"):
        if p.is_dir():
            shutil.rmtree(p, ignore_errors=True)


def write_commit_message(path: Path, lines: list[str]) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    with open(path, "w", encoding="utf-8") as f:
        f.write("\n".join(lines))
        if not lines[-1].endswith("\n"):
            f.write("\n")


def main() -> int:
    token = os.environ.get("SYNC_TOKEN") or os.environ.get("GITHUB_TOKEN")
    if not token:
        print("Falta SYNC_TOKEN o GITHUB_TOKEN", file=sys.stderr)
        return 1

    repo_b = Path(os.environ.get("REPO_B", "repo-b")).resolve()
    state_path = repo_b / "last_commits.json"
    msg_path = Path(os.environ.get("COMMIT_MSG_FILE", "commit_message.txt")).resolve()

    core = os.environ.get("CORE_REPO", "").strip()
    layers = os.environ.get("CORE_MERGE_REPOS", "").split()
    modules = os.environ.get("MODULE_REPOS", "").split()
    if not core:
        print("Falta CORE_REPO", file=sys.stderr)
        return 1

    apply_deletes = os.environ.get("SYNC_APPLY_DELETES", "1") not in ("0", "false", "no")

    spec = build_spec(core, layers, modules)
    remote_shas = [ls_remote_head_sha(token, s["repo"]) for s in spec]

    strip_submodule_ghost(repo_b)
    (repo_b / "modules").mkdir(parents=True, exist_ok=True)

    lines_msg: list[str] = [
        f"🚀 update-env: {os.environ.get('GITHUB_REPOSITORY', 'local')} "
        f"run {os.environ.get('GITHUB_RUN_NUMBER', '?')}",
        f"📅 {os.environ.get('GITHUB_EVENT_NAME', 'manual')}",
        "",
    ]

    # --- Bootstrap: solo punteros, sin tocar el árbol del ambiente ---
    if not state_path.is_file():
        state = {
            "version": STATE_VERSION,
            "sources": [
                {**spec[i], "sha": remote_shas[i]} for i in range(len(spec))
            ],
        }
        save_state(state_path, state)
        lines_msg.extend(
            [
                "📌 Bootstrap: registrados HEAD remotos en last_commits.json",
                "(sin sincronizar archivos; la próxima vez que cambie un SHA se aplicará el diff)",
                "",
                "[skip ci]",
            ]
        )
        write_commit_message(msg_path, lines_msg)
        sanitize_modules_modules(repo_b)
        print("Bootstrap completado.")
        return 0

    # --- Cargar estado y validar misma configuración ---
    data = load_state(state_path)
    prev = data.get("sources")
    if not isinstance(prev, list) or len(prev) != len(spec):
        print(
            "last_commits.json no coincide con la lista actual de repos "
            "(número de fuentes). Revisa o borra el archivo para un bootstrap nuevo.",
            file=sys.stderr,
        )
        return 1
    for i, (a, b) in enumerate(zip(prev, spec)):
        if a.get("repo") != b["repo"] or a.get("type") != b["type"]:
            print(
                f"Orden o repos distintos en índice {i}: {a} vs {b}. "
                "Ajusta last_commits.json o haz bootstrap de nuevo.",
                file=sys.stderr,
            )
            return 1

    stored = [str(p.get("sha", "")) for p in prev]

    if all(stored[i] == remote_shas[i] for i in range(len(spec))):
        lines_msg.append("✅ Sin cambios en remotos; no se sincroniza nada.")
        write_commit_message(msg_path, lines_msg + ["", "[skip ci]"])
        sanitize_modules_modules(repo_b)
        print("Sin novedades.")
        return 0

    lines_msg.append("📦 Aplicando deltas (jerarquía core → capas → módulos):")
    for i, s in enumerate(spec):
        if stored[i] == remote_shas[i]:
            continue
        repo = s["repo"]
        kind = s["type"]
        dest = repo_b if kind in ("core", "layer") else repo_b / "modules"
        lines_msg.append(f"  • {kind} {repo}: {stored[i][:7]}..{remote_shas[i][:7]}")
        apply_delta(
            token,
            repo,
            stored[i],
            remote_shas[i],
            dest,
            kind=kind,
            apply_deletes=apply_deletes,
        )

    new_state = {
        "version": STATE_VERSION,
        "sources": [{**spec[i], "sha": remote_shas[i]} for i in range(len(spec))],
    }
    save_state(state_path, new_state)
    lines_msg.extend(["", "✅ last_commits.json actualizado.", "", "[skip ci]"])
    write_commit_message(msg_path, lines_msg)
    sanitize_modules_modules(repo_b)
    print("Sincronización incremental completada.")
    return 0


if __name__ == "__main__":
    sys.exit(main())
