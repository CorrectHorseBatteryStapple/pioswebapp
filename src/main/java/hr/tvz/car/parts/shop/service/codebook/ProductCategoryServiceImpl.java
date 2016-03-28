package hr.tvz.car.parts.shop.service.codebook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.tvz.car.parts.shop.model.ProductCategory;
import hr.tvz.car.parts.shop.repository.codebook.ProductCategoryRepository;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    
    @Override
    public List<ProductCategory> findProductCategories() {
        return productCategoryRepository.findAll();
    }

}
