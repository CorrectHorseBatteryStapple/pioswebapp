package hr.tvz.car.parts.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.tvz.car.parts.shop.model.Product;
import hr.tvz.car.parts.shop.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findProducts() {
        return repository.findAll();
    }

    @Override
    public Product findProduct(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Product updateProduct(Product product) {
        repository.save(product);
        return null;
    }

}
