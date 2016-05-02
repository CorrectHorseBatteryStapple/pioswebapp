package hr.tvz.car.parts.shop.service.util;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

// TODO: @Component and autowire in service?
public class Emailer {

    private String         emailFrom = "test@test.com";
    private JavaMailSender emailer;

    public Emailer(JavaMailSender emailer, String emailFrom) {
        this.emailer = emailer;
        this.emailFrom = emailFrom;
    }

    @Async
    public void sendEmail(String emailTo, String header, String content) {
        System.out.println("content: " + content);
        System.out.println("emailTo: " + emailTo);

        SimpleMailMessage emailMessage = new SimpleMailMessage();
        emailMessage.setFrom(emailFrom);
        emailMessage.setReplyTo(emailFrom);
        emailMessage.setSubject(header);
        emailMessage.setText(content);
        emailMessage.setTo(emailTo);

        try {
            emailer.send(emailMessage);
            System.out.println("Email to " + emailTo + " sent successfully!");
        } catch (MailException e) {
            System.out.println("Error while sending email to " + emailTo + ": " + e.getMessage());
        }
    }

}
