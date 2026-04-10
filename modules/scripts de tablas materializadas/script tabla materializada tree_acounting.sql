CREATE MATERIALIZED VIEW em_sfcbr_tree_acounting AS
SELECT * FROM sfcbr_tree_acounting_v;





-- View: public.mv_tree_acct

-- DROP MATERIALIZED VIEW IF EXISTS public.mv_tree_acct;

CREATE MATERIALIZED VIEW IF NOT EXISTS public.mv_tree_acct
TABLESPACE pg_default
AS
 SELECT sfcbr_tree_acounting_v.p6,
    sfcbr_tree_acounting_v.p6name,
    sfcbr_tree_acounting_v.p5,
    sfcbr_tree_acounting_v.p5name,
    sfcbr_tree_acounting_v.p4,
    sfcbr_tree_acounting_v.p4name,
    sfcbr_tree_acounting_v.p3,
    sfcbr_tree_acounting_v.p3name,
    sfcbr_tree_acounting_v.p2,
    sfcbr_tree_acounting_v.p2name,
    sfcbr_tree_acounting_v.p1,
    sfcbr_tree_acounting_v.p1name,
    sfcbr_tree_acounting_v.id
   FROM sfcbr_tree_acounting_v
WITH DATA;

ALTER TABLE IF EXISTS public.mv_tree_acct
    OWNER TO tad;


CREATE INDEX idx_mv_tree_acct_id
    ON public.mv_tree_acct USING btree
    (id COLLATE pg_catalog."default")
    TABLESPACE pg_default;
