package hr.tvz.car.parts.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.tvz.car.parts.shop.model.User;
import hr.tvz.car.parts.shop.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User authenticateUser(String username, String password) {
        User user = repository.findByUsernameAndPassword(username, password);
        return user;
    }

}
