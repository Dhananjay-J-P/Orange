package orange.email;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class EmailThread implements Runnable {

	MailSender mailSender;

	Email email;

	public EmailThread(MailSender mailSender, Email email) {
		super();
		this.mailSender = mailSender;
		this.email = email;
	}

	public void run() {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(email.getFrom());
		message.setTo(email.getTo());
		message.setSubject(email.getSubject());
		message.setText(email.getMsg());
		mailSender.send(message);

	}

}
