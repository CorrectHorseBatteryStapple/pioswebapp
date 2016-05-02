package hr.tvz.car.parts.shop.service.util;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import hr.tvz.car.parts.shop.service.UserService;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailer;

    @Autowired
    private UserService    userService;

    @Value("${email.message.from}")
    private String         emailFrom;

    @SuppressWarnings("unused")
    private Emailer        emailerLocal;

    @PostConstruct
    private void init() {
        emailerLocal = new Emailer(emailer, emailFrom);
    }

    @Override
    // @Async
    public void sendEmail(Long userId, String header, String content) {
        // String emailTo = userService.findEmailByUserId(userId);
        // sendEmail(emailTo, header, content);
        // emailerLocal.sendEmail(emailTo, header, content);
    }

    @Override
    // @Async
    public void sendEmail(String emailTo, String header, String content) {
        // System.out.println("content: " + content);
        // System.out.println("emailTo: " + emailTo);
        //
        // SimpleMailMessage emailMessage = new SimpleMailMessage();
        // emailMessage.setFrom(emailFrom);
        // emailMessage.setReplyTo(emailFrom);
        // emailMessage.setSubject(header);
        // emailMessage.setText(content);
        // emailMessage.setTo(emailTo);
        //
        // try {
        // emailer.send(emailMessage);
        // System.out.println("Email to " + emailTo + " sent successfully!");
        // } catch (MailException e) {
        // System.out.println("Error while sending email to " + emailTo + ": " + e.getMessage());
        // }
    }

    @Override
    @Async
    public void sendConfirmOrderEmail(Long userId) {
        String header = "Zavrsetak narudzbe";
        String content = "Postovani, Vasa narudzba je zaprimljena. \nHvala Vam na ukazanom povjerenju.";
        // sendEmail(userId, subject, content);
        String emailTo = userService.findEmailByUserId(userId);
        // sendEmail(emailTo, header, content);
        emailerLocal.sendEmail(emailTo, header, content);
    }

    @Override
    @Async
    public void sendRegistrationEmail(String emailTo, boolean registrationSuccess) {
        String header = "CarPartsUnlimited - Potvrda registracije";
        String content = "Postovani, Vasa registracije je uspjesno zavrsena. \nHvala Vam na ukazanom povjerenju.";
        // sendEmail(emailTo, subject, content);
        emailerLocal.sendEmail(emailTo, header, content);
    }

}
