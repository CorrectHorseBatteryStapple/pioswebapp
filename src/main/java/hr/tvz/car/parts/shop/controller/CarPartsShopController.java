package hr.tvz.car.parts.shop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.car.parts.shop.mock.MockFactory;
import hr.tvz.car.parts.shop.model.Product;

@RestController
@RequestMapping(value = "/")
public class CarPartsShopController {
	
    @RequestMapping(value = "/products")
    public @ResponseBody List<Product> getCars() {
        return MockFactory.createMockProductList();
    }
    
}