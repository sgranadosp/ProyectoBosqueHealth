package co.edu.unbosque.util.mail;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 * Clase que facilita el envío de correos electrónicos a través de un servidor SMTP.
 * La clase utiliza la configuración de Gmail para el envío de mensajes.
 * 
 * Se requiere una cuenta de correo Gmail válida y la habilitación de acceso a aplicaciones menos seguras
 * para enviar el correo desde el servidor de Gmail.
 * 
 * @since 2024-11-10
 * @author David Esteban Caicedo Saldaña
 * @version 1.0
 */
public class Mail {
	/** Dirección de correo desde la cual se envían los correos. */
	private static String emailFrom = "de.caicedos@gmail.com";
	/** Contraseña de la cuenta de correo. */
	private static String passwordFrom = "fkvjuclrgktmqxfs";
	/** Dirección de correo del destinatario. */
	private String emailTo;
	 /** Asunto del correo. */
	private String subject;
	/** Contenido del correo. */
	private String content;

	/** Propiedades de la conexión SMTP. */
	private Properties mProperties;
	/** Sesión de correo electrónico. */
	private Session mSession;
	/** Objeto MimeMessage para enviar el correo. */
	private MimeMessage mCorreo;

	/**
     * Constructor de la clase {@link Mail}.
     * Inicializa las propiedades del correo electrónico.
     */
	public Mail() {
		mProperties = new Properties();
	}

	 /**
     * Crea un correo electrónico con la dirección del destinatario, el asunto y el contenido proporcionados.
     * 
     * @param et Dirección de correo del destinatario.
     * @param s Asunto del correo.
     * @param c Contenido del correo en formato HTML.
     */
	private void createEmail(String et, String s, String c) {

		emailTo = et.trim();
		subject = s.trim();
		content = c.trim();

		// Simple mail transfer protocol
		mProperties.put("mail.smtp.host", "smtp.gmail.com");
		mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		mProperties.setProperty("mail.smtp.starttls.enable", "true");
		mProperties.setProperty("mail.smtp.port", "587");
		mProperties.setProperty("mail.smtp.user", emailFrom);
		mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		mProperties.setProperty("mail.smtp.auth", "true");

		mSession = Session.getDefaultInstance(mProperties);

		try {
			mCorreo = new MimeMessage(mSession);
			mCorreo.setFrom(new InternetAddress(emailFrom));
			mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
			mCorreo.setSubject(subject);
			mCorreo.setText(content, "ISO-8859-1", "html");

		} catch (AddressException ex) {
			Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
		} catch (MessagingException ex) {
			Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
     * Envía el correo electrónico utilizando el protocolo SMTP.
     * Se conecta al servidor SMTP de Gmail, autentica la cuenta y envía el mensaje.
     */
	private void sendEmail() {
		try {
			Transport mTransport = mSession.getTransport("smtp");
			mTransport.connect(emailFrom, passwordFrom);
			mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
			mTransport.close();

			JOptionPane.showMessageDialog(null, "Correo enviado");
		} catch (NoSuchProviderException ex) {
			Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
		} catch (MessagingException ex) {
			Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
     * Método público que envía un correo electrónico.
     * 
     * @param et Dirección de correo del destinatario.
     * @param s Asunto del correo.
     * @param c Contenido del correo en formato HTML.
     */
	public void enviarC(String et, String s, String c) {
		createEmail(et, s, c);
		sendEmail();
	}

}
