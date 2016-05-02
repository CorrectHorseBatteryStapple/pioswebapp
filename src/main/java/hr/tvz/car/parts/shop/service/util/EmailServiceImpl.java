package hr.tvz.car.parts.shop.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.tvz.car.parts.shop.service.UserService;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private UserService userService;

    @Autowired
    private Emailer     emailer;

    @Override
    public void sendConfirmOrderEmail(Long userId) {
        String header = "Zavrsetak narudzbe";
        String content = "Postovani, Vasa narudzba je zaprimljena. \nHvala Vam na ukazanom povjerenju.";
        String emailTo = userService.findEmailByUserId(userId);
        emailer.sendEmail(emailTo, header, content);
    }

    @Override
    public void sendRegistrationEmail(String emailTo, boolean registrationSuccess) {
        String header = "CarPartsUnlimited - Potvrda registracije";
        String content = "";
        if (registrationSuccess) {
            content = "Postovani, Vasa registracije je uspjesno zavrsena. \nHvala Vam na ukazanom povjerenju.";
        } else {
            content = "Postovani, doslo je do pogreske prilikom registracije. Pokusajte ponovno kasnije.";
        }
        emailer.sendEmail(emailTo, header, content);
    }

}
