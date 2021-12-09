package com.news.main.repository;

import com.news.main.dto.UserRegistrationDto;
import org.springframework.data.jpa.repository.JpaRepository;

import com.news.main.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    User save(UserRegistrationDto registrationDto);
    User findByEmail(String email);

}
