package hr.tvz.car.parts.shop.model.dtofactory;

import hr.tvz.car.parts.shop.model.CartOrder;
import hr.tvz.car.parts.shop.model.OrderProduct;
import hr.tvz.car.parts.shop.model.dto.CartOrderDto;

public class DtoFactory {

    public static CartOrderDto transformCartOrderToDto(CartOrder cartOrder) {
        CartOrderDto cartOrderDto = new CartOrderDto();
        if(cartOrder != null) {
            cartOrderDto.setId(cartOrder.getId());
            cartOrderDto.setOrderStatus(cartOrder.getOrderStatus());
            cartOrderDto.setTimestamp(cartOrder.getTimestamp().toString());
            
            for(OrderProduct orderProduct : cartOrder.getOrderProductList()) {
                cartOrderDto.getCartProductList().add(orderProduct.getProduct());
            }
        }
        return cartOrderDto;
    }
    
}
