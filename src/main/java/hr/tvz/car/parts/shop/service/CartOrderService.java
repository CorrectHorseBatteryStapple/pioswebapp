package hr.tvz.car.parts.shop.service;

import hr.tvz.car.parts.shop.model.CartOrder;
import hr.tvz.car.parts.shop.model.enums.CartUpdateType;

public interface CartOrderService {

    CartOrder findUserCartDetails(Long userId);

    void updateCart(Long userId, Long productId, CartUpdateType cartUpdateType);

    void confirmOrder(Long userId);

}
