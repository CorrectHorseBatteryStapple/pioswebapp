package hr.tvz.car.parts.shop.service.util;

public interface EmailService {

    void sendConfirmOrderEmail(Long userId);

    void sendRegistrationEmail(String email, boolean registrationSuccess);

}
