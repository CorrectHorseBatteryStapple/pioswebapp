package hr.tvz.car.parts.shop.service;

import java.util.List;

import hr.tvz.car.parts.shop.model.Product;

public interface ProductService {

    List<Product> findProducts();

    Product findProduct(Long id);
}
