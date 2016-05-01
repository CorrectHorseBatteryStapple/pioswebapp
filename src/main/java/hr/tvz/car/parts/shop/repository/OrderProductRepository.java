package hr.tvz.car.parts.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.tvz.car.parts.shop.model.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}
