package com.CentreCulturel.demo.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
Optional<User> findByEmail(String email);

Optional<User> findByEmailAndPassword(String email, String password);
Optional<User> findByMessagesId(Integer id);
}
