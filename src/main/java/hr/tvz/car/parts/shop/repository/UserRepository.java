package hr.tvz.car.parts.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.tvz.car.parts.shop.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

}
