package hr.tvz.car.parts.shop.service.util;

public interface EmailService {

    void sendEmail(String emailTo, String header, String content);

    void sendEmail(Long userId, String header, String content);

    void sendConfirmOrderEmail(Long userId);

    void sendRegistrationEmail(String email, boolean registrationSuccess);

}
