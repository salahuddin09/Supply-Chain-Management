package org.scm.utilities;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
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
import org.scm.model.Product;

/**
 *
 * @author Personal
 */
public class SendMail {
    
    public static void sendMessage() {
        Properties props = new Properties();
        final Mail mail = new Mail();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
                
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(mail.getUserName(),mail.getPassword());
				}
			});
 
		try {
 
			Message message = new MimeMessage(session);
			
                        
			message.setFrom(new InternetAddress(mail.getFrom()));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(mail.getRecipients()));
			message.setSubject(mail.getSubject());
                        
                        
                        MimeBodyPart mbp = new MimeBodyPart();
                        mbp.setText("Dear Supplier,\n Please deliver the products mentioned in the attached invoice within 7 days starting from the message delivery date.\nWith regards,Manager.");
                        Multipart multipart = new MimeMultipart();
                        multipart.addBodyPart(mbp);
                        // Part two is attachment
                        mbp = new MimeBodyPart();
                        DataSource source = new FileDataSource(mail.getFileAttachment());
                        mbp.setDataHandler(new DataHandler(source));
                     //   mbp.setFileName(mail.getFileAttachment());
                        multipart.addBodyPart(mbp);

                        // Put parts in message
                        message.setContent(multipart);

                        
			Transport.send(message);
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
    }
    
}
