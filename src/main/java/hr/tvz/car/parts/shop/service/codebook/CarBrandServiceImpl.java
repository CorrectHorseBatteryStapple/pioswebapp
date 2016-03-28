package hr.tvz.car.parts.shop.service.codebook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.tvz.car.parts.shop.model.CarBrand;
import hr.tvz.car.parts.shop.repository.codebook.CarBrandRepository;

@Service
public class CarBrandServiceImpl implements CarBrandService {

    @Autowired
    private CarBrandRepository carBrandRepository;
    
    @Override
    public List<CarBrand> findCarBrands() {
        return carBrandRepository.findAll();
    }

}
