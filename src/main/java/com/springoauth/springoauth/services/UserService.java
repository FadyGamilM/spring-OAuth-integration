package com.springoauth.springoauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springoauth.springoauth.api.models.RegisterUserDto;
import com.springoauth.springoauth.domain.User;
import com.springoauth.springoauth.repositories.UserRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private final UserRepo _repo;

    public User Register(RegisterUserDto dto) {
        var user = new User();
        user.setPassword(dto.getPassword());
        user.setUsername(dto.getUsername());
        var persistedUser = _repo.save(user);
        return persistedUser;
    }

}