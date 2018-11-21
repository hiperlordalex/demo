package com.alex.demo.modell.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmailAddessAndPassword(String emailAddess,String password);

    boolean existsByEmailAddessAndPassword(String emailAddess, String password);

}
