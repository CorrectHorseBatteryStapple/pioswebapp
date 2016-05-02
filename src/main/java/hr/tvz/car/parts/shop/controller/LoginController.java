package hr.tvz.car.parts.shop.controller;

import java.util.Date;

import javax.servlet.ServletException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.car.parts.shop.model.User;
import hr.tvz.car.parts.shop.model.dto.LoginDto;
import hr.tvz.car.parts.shop.model.dto.RegistrationDto;
import hr.tvz.car.parts.shop.model.dto.SimpleCarPartBackendResponse;
import hr.tvz.car.parts.shop.model.dto.UserDto;
import hr.tvz.car.parts.shop.model.dtofactory.DtoFactory;
import hr.tvz.car.parts.shop.model.enums.JWTSignature;
import hr.tvz.car.parts.shop.service.UserService;
import hr.tvz.car.parts.shop.service.util.EmailService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(value = "/")
public class LoginController {

    @Autowired
    private UserService  userService;

    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody SimpleCarPartBackendResponse authenticateUser(@Valid @RequestBody LoginDto loginDto) throws ServletException {
        SimpleCarPartBackendResponse simpleCarPartBackendResponse = new SimpleCarPartBackendResponse();
        String statusMessage = "";

        User tempUser = userService.authenticateUser(loginDto.getUsername(), loginDto.getPassword());
        if (tempUser != null) {
            UserDto userDto = DtoFactory.transformUserToUserDto(tempUser);
            statusMessage = "Bingo! Uspjesna prijava!";
            simpleCarPartBackendResponse.setStatusMessage(statusMessage);
            simpleCarPartBackendResponse.setData(userDto);

            String jwtToken = Jwts.builder().setSubject(tempUser.getFirstname()).claim("roles", tempUser.getRole().getName()).setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, JWTSignature.KEY.getValue()).compact();
            System.out.println("JWT token: " + jwtToken);
            simpleCarPartBackendResponse.setToken(jwtToken);
        } else {
            statusMessage = "Greska: Korisnik " + loginDto.getUsername() + " ne postoji ili je unesen krivi password";
            throw new ServletException(statusMessage);
        }
        return simpleCarPartBackendResponse;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public SimpleCarPartBackendResponse registerUser(@Valid @RequestBody RegistrationDto registrationDto) throws ServletException {
        SimpleCarPartBackendResponse response = new SimpleCarPartBackendResponse();
        User tempUser = DtoFactory.createUserFrom(registrationDto);
        if (userService.findUserByEmail(tempUser.getUsername()) != null) {
            throw new ServletException("Registration failed. - Korisnik sa istim emailom vec postoji.");
        }
        User savedUser = userService.save(tempUser);
        boolean registrationSuccess = true;

        if (savedUser != null) {
            response.setStatusMessage("Registration successful.");
            emailService.sendRegistrationEmail(savedUser.getUsername(), registrationSuccess);
        } else {
            response.setStatusMessage("Registration failed.");
            emailService.sendRegistrationEmail(tempUser.getUsername(), !registrationSuccess);
        }

        return response;
    }

}
