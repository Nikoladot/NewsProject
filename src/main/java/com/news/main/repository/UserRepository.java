package com.news.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.news.main.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
