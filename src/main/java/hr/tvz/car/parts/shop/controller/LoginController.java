package hr.tvz.car.parts.shop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.car.parts.shop.model.User;
import hr.tvz.car.parts.shop.model.dto.RegistrationDto;
import hr.tvz.car.parts.shop.model.dto.SimpleCarPartBackendResponse;
import hr.tvz.car.parts.shop.model.dto.UserDto;
import hr.tvz.car.parts.shop.model.dtofactory.DtoFactory;
import hr.tvz.car.parts.shop.service.UserService;

@RestController
@RequestMapping(value = "/")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody SimpleCarPartBackendResponse authenticateUser(@RequestParam(required = false) String username,
            @RequestParam(required = false) String password) {
        SimpleCarPartBackendResponse simpleCarPartBackendResponse = new SimpleCarPartBackendResponse();
        String statusMessage = "";
        if (username == null || password == null) {
            statusMessage = "Super secret login page. Error: you need to send some data, username and password is empty";
            simpleCarPartBackendResponse.setStatusMessage(statusMessage);
            return simpleCarPartBackendResponse;
        }

        User tempUser = userService.authenticateUser(username, password);
        if (tempUser != null) {
            UserDto userDto = DtoFactory.transformUserToUserDto(tempUser);
            statusMessage = "Bingo! Uspjesna prijava!";
            simpleCarPartBackendResponse.setStatusMessage(statusMessage);
            simpleCarPartBackendResponse.setData(userDto);
        } else {
            statusMessage = "Greska: Korisnik " + username + " ne postoji ili je unesen krivi password";
            simpleCarPartBackendResponse.setStatusMessage(statusMessage);
        }
        return simpleCarPartBackendResponse;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public SimpleCarPartBackendResponse registerUser2(@Valid @RequestBody RegistrationDto registrationDto) {
        SimpleCarPartBackendResponse response = new SimpleCarPartBackendResponse();
        User tempUser = DtoFactory.createUserFrom(registrationDto);
        User savedUser = userService.save(tempUser);
        if (savedUser != null) {
            // send mail..etc
            response.setStatusMessage("Registration successful.");
        } else {
            response.setStatusMessage("Registration failed.");
        }

        return response;
    }

}
