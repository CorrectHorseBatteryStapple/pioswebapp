package hr.tvz.car.parts.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.tvz.car.parts.shop.model.User;
import hr.tvz.car.parts.shop.repository.UserRepository;
import hr.tvz.car.parts.shop.service.codebook.RoleService;

@Service
public class UserServiceImpl implements UserService {

    private static final String ROLE_USER = "User";

    @Autowired
    private UserRepository      repository;

    @Autowired
    private RoleService         roleService;

    @Override
    public User authenticateUser(String username, String password) {
        User user = repository.findByUsernameAndPassword(username, password);
        return user;
    }

    @Override
    public User save(User user) {
        user.setRole(roleService.findByName(ROLE_USER));
        return repository.save(user);
    }

    @Override
    public String findEmailByUserId(Long userId) {
        User user = repository.findOne(userId);
        return user != null ? user.getUsername() : "";
    }

    @Override
    public User findUserByEmail(String username) {
        return repository.findByUsername(username);
    }

}
