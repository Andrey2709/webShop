package com.example.shop.controllers;

import com.example.shop.model.User;
import com.example.shop.services.UserServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {


   private UserServiceImpl service;

    public UserController(UserServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/admin/users")
    public List<User> findAllUsers() {
        return service.findAll();
    }

    @GetMapping("/home")
    public ResponseEntity<Map<String,String>> home(){

       UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Map.of("greeting", "Hello " + userDetails.getUsername() + " " + userDetails.getAuthorities()));
    }
}
