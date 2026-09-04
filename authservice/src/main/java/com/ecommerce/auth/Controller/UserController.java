package com.ecommerce.auth.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.auth.Entity.User;
import com.ecommerce.auth.Enums.Role;
import com.ecommerce.auth.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
    

    private UserService userservice;

    public UserController(UserService userservice){

        this.userservice=userservice;
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@Valid @PathVariable Long id){

        return userservice.findUserById(id);
    }

    @GetMapping("/search")
    public Optional<User> getUserByEmail(@Valid @RequestParam String email){

        return userservice.findUserByEmail(email);
    }

    @GetMapping("/role")
    public List<User> getUserByRole(@Valid @RequestParam Role role){

        return userservice.findUserByRole(role);
    }

   @DeleteMapping("/{id}")
    public void deleteUserById(@Valid @PathVariable Long id){

        userservice.deleteUserById(id);
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user){

        return userservice.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@Valid @RequestBody User user){

        return userservice.updateUser(user);
    }
}
