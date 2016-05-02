package hr.tvz.car.parts.shop.service.util;

public interface Emailer {

    void sendEmail(String emailTo, String header, String content);
}
