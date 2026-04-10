package ec.com.sidesoft.email.utils;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.openbravo.model.ad.utility.Image;
import org.openbravo.utils.FormatUtilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ec.com.sidesoft.email.AemSmtpConfig;

public class EmailConnectionUtils {
  private static final Logger log = LoggerFactory.getLogger(EmailConnectionUtils.class);
  private static String TIMEOUT_MS = "60000"; // Debería ser configurable

  /**
   * Envía un correo electrónico multipart.
   * 
   * @param config
   *          Configuración del servidor SMTP.
   * @param to
   *          Destinatario(s).
   * @param replyTo
   *          Dirección de respuesta (anteriormente llamada 'from').
   * @param subject
   *          Asunto.
   * @param body
   *          Cuerpo HTML.
   * @param logo
   *          Imagen opcional para embeber.
   * @throws MessagingException
   *           Si hay error en el transporte.
   * @throws IllegalArgumentException
   *           Si la configuración es inválida.
   */
  public static void send(AemSmtpConfig config, String to, String replyTo, String subject,
      String body, Image logo) throws MessagingException {

    if (config == null) {
      throw new IllegalArgumentException("La configuración SMTP no puede ser nula.");
    }

    // 1. Configurar Sesión
    Session session = createSession(config);

    // 2. Construir Mensaje
    MimeMessage message = new MimeMessage(session);

    // Headers
    configureHeaders(message, config, to, replyTo, subject);

    // Body & Multipart
    Multipart multipart = buildMultipartContent(body, logo);
    message.setContent(multipart);
    message.setSentDate(new Date());

    // 3. Enviar
    Transport.send(message);
    log.info("Correo enviado exitosamente a: {}", to);
  }

  private static Session createSession(AemSmtpConfig config) {
    final AemSmtpConfig cf = config;
    TIMEOUT_MS = (cf.getTimeoutseconds().isEmpty() ? TIMEOUT_MS : cf.getTimeoutseconds());
    Properties props = new Properties();
    props.put("mail.smtp.host", cf.getHost());
    props.put("mail.smtp.port", cf.getPort());
    props.put("mail.smtp.connectiontimeout", TIMEOUT_MS);
    props.put("mail.smtp.timeout", TIMEOUT_MS);

    String security = cf.getSecurityConn() != null ? cf.getSecurityConn().toUpperCase() : "N";
    String useAuth = cf.isUSEAuth() ? "true" : "false";

    switch (security) {
    case "SSL":
      props.put("mail.smtp.auth", useAuth);
      props.put("mail.smtp.ssl.enable", "true");
      props.put("mail.smtp.ssl.protocols", "TLSv1.2 TLSv1.3");
      props.put("mail.smtp.socketFactory.port", cf.getPort());
      props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      props.put("mail.smtp.socketFactory.fallback", "false");
      break;
    case "STARTTLS":
      props.put("mail.smtp.auth", useAuth);
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.starttls.required", "true");
      props.put("mail.smtp.ssl.protocols", "TLSv1.2 TLSv1.3");
    default:
      props.put("mail.smtp.auth", cf.isUSEAuth() ? "true" : "false");
      break;
    }

    if (cf.isUSEAuth()) {
      return Session.getInstance(props, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
          String password = "";
          try {
            String encrypted = cf.getPassword();
            if (encrypted != null) {
              password = FormatUtilities.encryptDecrypt(encrypted, false);
            }
          } catch (Exception e) {
            log.error("Error desencriptando contraseña SMTP", e);
            // No relanzamos para no romper el flujo estático, pero loggeamos severo
          }
          return new PasswordAuthentication(cf.getSMTPServerAccount(), password);
        }
      });
    } else {
      return Session.getInstance(props);
    }
  }

  private static void configureHeaders(MimeMessage message, AemSmtpConfig config, String to,
      String replyTo, String subject) throws MessagingException {

    // FROM
    if (config.getFromName() != null && !config.getFromName().isEmpty()) {
      try {
        message.setFrom(new InternetAddress(config.getFromEmail(), config.getFromName()));
      } catch (Exception e) {
        message.setFrom(new InternetAddress(config.getFromEmail()));
      }
    } else {
      message.setFrom(new InternetAddress(config.getFromEmail()));
    }

    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

    if (replyTo != null && !replyTo.trim().isEmpty()) {
      String cleanedReplyTo = replyTo.replace(";", ",").replaceAll("\\s+", "");
      message.setReplyTo(InternetAddress.parse(cleanedReplyTo));
    }

    message.setSubject(subject);
  }

  private static Multipart buildMultipartContent(String body, Image logo)
      throws MessagingException {
    MimeMultipart multipart = new MimeMultipart("related");
    String finalHtmlBody;

    // Corrección del BUG LÓGICO original
    boolean hasLogo = (logo != null && logo.getBindaryData() != null);

    if (hasLogo) {
      finalHtmlBody = body.replace("&lt;logo_cid&gt;", "<img src=\"cid:logo_cid\">");
    } else {
      finalHtmlBody = body.replace("&lt;logo_cid&gt;", "");
    }

    // Parte HTML
    MimeBodyPart htmlPart = new MimeBodyPart();
    htmlPart.setContent(finalHtmlBody, "text/html; charset=utf-8");
    multipart.addBodyPart(htmlPart);

    // Parte Imagen (Solo si existe)
    if (hasLogo) {
      MimeBodyPart logoPart = new MimeBodyPart();
      ByteArrayDataSource ds = new ByteArrayDataSource(logo.getBindaryData(), logo.getMimetype());
      logoPart.setDataHandler(new DataHandler(ds));
      logoPart.setHeader("Content-ID", "<logo_cid>"); // Los CIDs suelen ir entre brackets <>
      logoPart.setFileName(
          "logo_" + System.currentTimeMillis() + "." + getExtension(logo.getMimetype()));
      logoPart.setHeader("Content-Type", logo.getMimetype());
      logoPart.setDisposition(MimeBodyPart.INLINE); // Importante para que no sea attachment
      multipart.addBodyPart(logoPart);
    }

    return multipart;
  }

  private static String getExtension(String mimeType) {
    if (mimeType == null)
      return "dat";
    return mimeType.replace("image/", "");
  }

}