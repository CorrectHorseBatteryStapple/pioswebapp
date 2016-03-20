package hr.tvz.car.parts.shop.mock;

import java.util.ArrayList;
import java.util.List;

import hr.tvz.car.parts.shop.model.Product;

public class MockFactory {

    /**
     * creates List with fictive(mock) car parts until database is set up.
     * @return
     */
    public static List<Product> createMockProductList() {
        List<Product> mockProductList = new ArrayList<>();
        mockProductList.add(new Product("Hauba", "H-515", "02534059234-534", "1x123x125", 254.23D));
        mockProductList.add(new Product("Getriba", "G-515", "32645645-534", "43x13x25", 1254.23D));
        mockProductList.add(new Product("Akumulator", "A-515", "344654567-534", "13x13x25", 154.23D));
        
        return mockProductList;
    }
    
}
