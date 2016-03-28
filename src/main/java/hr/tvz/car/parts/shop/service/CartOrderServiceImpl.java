package hr.tvz.car.parts.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.tvz.car.parts.shop.model.CartOrder;
import hr.tvz.car.parts.shop.repository.CartOrderRepository;

@Service
public class CartOrderServiceImpl implements CartOrderService {

    @Autowired
    private CartOrderRepository cartOrderRepository;

    @Override
    public CartOrder findUserCartDetails(Long userId) {
        
        // TODO: only 1 active cart per user - where status is not done, not ordered
        return cartOrderRepository.findByUserId(userId);
    }
    
    
}
