package hr.tvz.car.parts.shop.service.codebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.tvz.car.parts.shop.model.Role;
import hr.tvz.car.parts.shop.repository.codebook.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;

    @Override
    public Role findByName(String name) {
        return repository.findByName(name);
    }

}
