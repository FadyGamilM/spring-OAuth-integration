package com.springoauth.springoauth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springoauth.springoauth.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {

}