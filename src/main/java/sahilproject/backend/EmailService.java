package sahilproject.backend;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String from, String name, String subject, String messageBody) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        // Set email fields
        helper.setFrom(from);  // Email from the user who filled the form
        helper.setTo("your-email@gmail.com");  // Your email address to receive the form submission
        helper.setSubject(subject);  // Subject of the email
        helper.setText("Message from: " + name + "\n\n" + messageBody, false);  // Text message

        mailSender.send(message);
    }
}
