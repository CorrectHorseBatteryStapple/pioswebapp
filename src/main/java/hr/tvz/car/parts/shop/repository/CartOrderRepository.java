package hr.tvz.car.parts.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.tvz.car.parts.shop.model.CartOrder;

public interface CartOrderRepository extends JpaRepository<CartOrder, Long> {
    
    CartOrder findByUserId(Long userId);
}
