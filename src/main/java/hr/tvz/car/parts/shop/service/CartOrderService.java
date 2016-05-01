package hr.tvz.car.parts.shop.service;

import hr.tvz.car.parts.shop.model.CartOrder;
import hr.tvz.car.parts.shop.model.dto.CartOrderDto;

public interface CartOrderService {

    CartOrder findUserCartDetails(Long userId);

    void updateCart(CartOrderDto cartOrderDto);

}
