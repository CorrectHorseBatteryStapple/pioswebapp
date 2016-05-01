package hr.tvz.car.parts.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.tvz.car.parts.shop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByActiveTrue();

    Product findByIdAndActiveTrue(Long id);

}
