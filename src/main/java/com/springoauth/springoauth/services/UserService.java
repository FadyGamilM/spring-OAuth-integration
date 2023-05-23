package com.springoauth.springoauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.springoauth.springoauth.api.models.RegisterUserDto;
import com.springoauth.springoauth.domain.User;
import com.springoauth.springoauth.events.RegisterationCompletedEvent;
import com.springoauth.springoauth.repositories.UserRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    private final UserRepo _repo;

    @Autowired
    private ApplicationEventPublisher _publisher;

    public User Register(RegisterUserDto dto) {
        var user = new User();
        user.setPassword(dto.getPassword());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        var persistedUser = _repo.save(user);
        // once we got the persisted user from db we need to publish an event so we can
        // send the email verification to the user email
        _publisher.publishEvent(new RegisterationCompletedEvent(user, "verification-url"));
        return persistedUser;
    }

}