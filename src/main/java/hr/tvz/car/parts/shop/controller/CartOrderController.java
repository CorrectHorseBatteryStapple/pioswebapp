package hr.tvz.car.parts.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.car.parts.shop.model.CartOrder;
import hr.tvz.car.parts.shop.model.dto.CartOrderDto;
import hr.tvz.car.parts.shop.model.dtofactory.DtoFactory;
import hr.tvz.car.parts.shop.service.CartOrderService;

@RestController
@RequestMapping(value = "/cart")
public class CartOrderController {

    @Autowired
    private CartOrderService cartOrderService;
    
    @RequestMapping(value = "/details")
    public @ResponseBody CartOrderDto getCartOrderList(@RequestParam Long userId) {
        // TODO: get logged in user id
        // only 1 active cart order per user
        System.out.println("userId: " +  userId + " requested /cart/details");
        CartOrder userCartDetails = cartOrderService.findUserCartDetails(userId);
        CartOrderDto cartOrderToDto = DtoFactory.transformCartOrderToDto(userCartDetails);
        return cartOrderToDto;
    }
}
