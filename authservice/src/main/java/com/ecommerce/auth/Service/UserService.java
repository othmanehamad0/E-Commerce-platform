package com.ecommerce.auth.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.auth.Entity.User;
import com.ecommerce.auth.Enums.Role;
import com.ecommerce.auth.Repository.UserRepository;
import com.ecommerce.auth.validation.UserValidation;


@Service
public class UserService {


    private final UserRepository userRepository;
    private final UserValidation userValidation;
    private final PasswordEncoder passwordEncoder;



    public UserService(
            UserRepository userRepository,
            UserValidation userValidation,
            PasswordEncoder passwordEncoder
    ) {

        this.userRepository = userRepository;
        this.userValidation = userValidation;
        this.passwordEncoder = passwordEncoder;

    }



    // Find user by ID
    public Optional<User> findUserById(Long id) {

        userValidation.validateID(id);

        return userRepository.findById(id);
    }



    // Find user by email
    public Optional<User> findUserByEmail(String email) {

        userValidation.validateEmailPattern(email);

        return userRepository.findByEmail(email);
    }



    // Find users by role
    public List<User> findUserByRole(Role role) {

        userValidation.checkRole(role);

        return userRepository.findByRole(role);
    }



    // Delete user
    public void deleteUserById(Long id) {

        userValidation.validateID(id);

        userRepository.deleteById(id);
    }




    // Create user
    public User createUser(User user) {


        // Validate email format
        userValidation.validateEmailPattern(user.getEmail());


        // Check email already exists
        userValidation.validateEmailAlreadyExists(
                user.getEmail()
        );



        // Hash password
        String hashedPassword =
                passwordEncoder.encode(user.getPassword());


        user.setPassword(hashedPassword);



        // Give default role
        if(user.getRole() == null){

            user.setRole(Role.USER);

        }



        return userRepository.save(user);

    }




    // Update user
    public User updateUser(User user) {


        userValidation.validateID(user.getId());


        userValidation.validateEmailPattern(
                user.getEmail()
        );


        userValidation.validateEmailAlreadyExists(
                user.getEmail(),
                user.getId()
        );


        userValidation.checkRole(
                user.getRole()
        );



        // Hash password only if user changes it
        if(user.getPassword() != null 
                && !user.getPassword().isBlank()){

            user.setPassword(
                    passwordEncoder.encode(user.getPassword())
            );

        }



        return userRepository.save(user);

    }

}