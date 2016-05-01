package hr.tvz.car.parts.shop.repository.codebook;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.tvz.car.parts.shop.model.OrderStatus;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {

    OrderStatus findByStatus(String status);

}
