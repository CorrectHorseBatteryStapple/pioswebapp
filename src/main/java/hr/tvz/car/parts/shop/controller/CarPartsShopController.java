package hr.tvz.car.parts.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hr.tvz.car.parts.shop.model.CarBrand;
import hr.tvz.car.parts.shop.model.Product;
import hr.tvz.car.parts.shop.model.ProductCategory;
import hr.tvz.car.parts.shop.model.dto.SimpleCarPartBackendResponse;
import hr.tvz.car.parts.shop.service.ProductService;
import hr.tvz.car.parts.shop.service.codebook.CarBrandService;
import hr.tvz.car.parts.shop.service.codebook.ProductCategoryService;

@RestController
@RequestMapping(value = "/shop")
public class CarPartsShopController {

    @Autowired
    private CarBrandService        carBrandService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductService         productService;

    @RequestMapping(value = "/car-brands")
    public @ResponseBody List<CarBrand> getCarBrands() {
        return carBrandService.findCarBrands();
    }

    @RequestMapping(value = "/product-categories")
    public @ResponseBody List<ProductCategory> getProductCategories() {
        return productCategoryService.findProductCategories();
    }

    @RequestMapping(value = "/products")
    public @ResponseBody List<Product> getProducts() {
        return productService.findProducts();
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public @ResponseBody Product getProduct(@PathVariable("id") Long id) {
        return productService.findProduct(id);
    }

    @RequestMapping(value = "/product/edit", method = RequestMethod.POST)
    public @ResponseBody Product getProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @RequestMapping(value = "/product/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody SimpleCarPartBackendResponse deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new SimpleCarPartBackendResponse();
    }

}