package hr.tvz.car.parts.shop.model.dtofactory;

import hr.tvz.car.parts.shop.model.CartOrder;
import hr.tvz.car.parts.shop.model.OrderProduct;
import hr.tvz.car.parts.shop.model.User;
import hr.tvz.car.parts.shop.model.dto.CartOrderDto;
import hr.tvz.car.parts.shop.model.dto.UserDto;

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
    
    public static UserDto transformUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        if(user != null) {
            userDto.setId(user.getId());
            userDto.setFirstname(user.getFirstname());
            userDto.setLastname(user.getLastname());
            userDto.setUsername(user.getUsername());
            userDto.setAddress(user.getAddress());
            userDto.setPhoneNumber(user.getPhoneNumber());
        }
        return userDto;
    }
    
}