package hr.tvz.car.parts.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.tvz.car.parts.shop.model.Product;
import hr.tvz.car.parts.shop.repository.ProductRepository;
import hr.tvz.car.parts.shop.repository.codebook.CarBrandRepository;
import hr.tvz.car.parts.shop.repository.codebook.ProductCategoryRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository         repository;

    @Autowired
    private CarBrandRepository        carBrandRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<Product> findProducts() {
        return repository.findByActiveTrue();
    }

    @Override
    public Product findProduct(Long id) {
        return repository.findByIdAndActiveTrue(id);
    }

    @Override
    public Product updateProduct(Product product) {
        product.setActive(true);

        if (product.getId() == null) {
            product.setCarBrand(carBrandRepository.findOne(1L));
            product.setProductCategory(productCategoryRepository.findOne(1L));
        }
        return repository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = repository.findOne(id);
        if (product != null) {
            product.setActive(false);
        }
        repository.save(product);
    }

}
