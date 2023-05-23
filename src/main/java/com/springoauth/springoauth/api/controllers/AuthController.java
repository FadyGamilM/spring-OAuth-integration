package com.springoauth.springoauth.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springoauth.springoauth.api.models.RegisterUserDto;
import com.springoauth.springoauth.services.UserService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

   @Autowired
   private final UserService _service;

   @PostMapping("/register")
   public String Register(@RequestBody RegisterUserDto user) {
      if (_service.Register(user) != null)
         return "success";
      else
         return "faliure";
   }
}