package hr.tvz.car.parts.shop.service;

import hr.tvz.car.parts.shop.model.CartOrder;

public interface CartOrderService {

    CartOrder findUserCartDetails(Long userId);

}
