package hr.tvz.car.parts.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.car.parts.shop.model.CartOrder;
import hr.tvz.car.parts.shop.model.dto.CartOrderDto;
import hr.tvz.car.parts.shop.model.dto.SimpleCarPartBackendResponse;
import hr.tvz.car.parts.shop.model.dtofactory.DtoFactory;
import hr.tvz.car.parts.shop.model.enums.CartUpdateType;
import hr.tvz.car.parts.shop.service.CartOrderService;

@RestController
@RequestMapping(value = "/cart")
public class CartOrderController {

    @Autowired
    private CartOrderService cartOrderService;

    @RequestMapping(value = "/details/{userId}", method = RequestMethod.GET)
    public @ResponseBody CartOrderDto getCartOrderList(@PathVariable Long userId) {
        // only 1 active cart order per user
        System.out.println("userId: " + userId + " requested /cart/details");
        CartOrder userCartDetails = cartOrderService.findUserCartDetails(userId);
        CartOrderDto cartOrderToDto = DtoFactory.transformCartOrderToDto(userCartDetails);
        return cartOrderToDto;
    }

    @RequestMapping(value = "/update/{updateType}/{userId}/{productId}", method = RequestMethod.GET)
    public @ResponseBody SimpleCarPartBackendResponse addToCart(@PathVariable String updateType, @PathVariable Long userId, @PathVariable Long productId) {
        System.out.println("updateType: " + updateType + "userId: " + userId + " requested /cart/update with productId " + productId);
        cartOrderService.updateCart(userId, productId, CartUpdateType.from(updateType));
        return new SimpleCarPartBackendResponse();
    }

}
