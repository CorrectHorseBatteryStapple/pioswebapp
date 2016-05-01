package hr.tvz.car.parts.shop.repository.codebook;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.tvz.car.parts.shop.model.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
