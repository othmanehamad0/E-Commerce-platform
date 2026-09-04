package com.ecommerce.auth.validation;

import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecommerce.auth.Entity.User;
import com.ecommerce.auth.Enums.Role;
import com.ecommerce.auth.Repository.UserRepository;

@Component
public class UserValidation {

    private static final Logger logger =
            LoggerFactory.getLogger(UserValidation.class);


    private final UserRepository userRepository;


    public UserValidation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void validateID(Long id) {

        if (id == null) {

            logger.error("User ID cannot be null");

            throw new IllegalArgumentException(
                    "User ID cannot be null"
            );
        }


        if (id <= 0) {

            logger.error("User ID must be positive");

            throw new IllegalArgumentException(
                    "User ID must be positive"
            );
        }
    }


    public void validateEmailExistance(String email) {

        if (!userRepository.existsByEmail(email)) {

            logger.warn("Email does not exists: {}", email);

            throw new IllegalArgumentException(
                    "Email does not exists"
            );
        }
    }


    public void validateEmailPattern(String email) {

        if (email == null) {

            logger.error("User cannot be null");

            throw new IllegalArgumentException(
                    "User cannot be null"
            );
        }


        String pattern =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";


        if (email == null ||
            !email.matches(pattern)) {

            logger.warn("Invalid email format");

            throw new IllegalArgumentException(
                    "Wrong email format"
            );
        }
    }


    public void checkRole(Role role) {


        if (role == Role.ADMIN) {

            logger.info("User role is ADMIN");

        } else if (role == Role.USER) {

            logger.info("User role is USER");

        } else {

            logger.warn("Invalid user role");

            throw new IllegalArgumentException(
                    "Role must be ADMIN or USER"
            );
        }
    }

        public void validateEmailAlreadyExists(String email) {

        if (userRepository.existsByEmail(email)) {

            logger.warn("Email already exists: {}", email);

            throw new IllegalArgumentException(
                    "Email already exists"
            );
        }
    }
    public void validateEmailAlreadyExists(String email, Long userId) {

    User existingUser = userRepository.findByEmail(email)
            .orElse(null);

    if (existingUser != null && 
        !existingUser.getId().equals(userId)) {

        throw new IllegalArgumentException(
                "Email already used by another user"
        );
    }
}
}