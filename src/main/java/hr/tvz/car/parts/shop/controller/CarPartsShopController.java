package hr.tvz.car.parts.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class CarPartsShopController {
	
    @RequestMapping(value = "/cars")
    public @ResponseBody String getCars() {
        return "bla";
    }
}