package kz.lab9.repositories;

import kz.lab9.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    List<User> findAllByNameContainsAndAge(String name, Integer age);

}
