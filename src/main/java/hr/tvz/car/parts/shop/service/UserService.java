package hr.tvz.car.parts.shop.service;

import hr.tvz.car.parts.shop.model.User;

public interface UserService {

    User authenticateUser(String username, String password);

}
