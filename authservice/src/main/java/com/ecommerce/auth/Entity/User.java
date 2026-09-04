package com.ecommerce.auth.Entity;

// JPA
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

// Validation
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// Java
import java.time.LocalDate;

// Custom Enum
import com.ecommerce.auth.Enums.Role;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "username", unique = false, nullable = false)
    @NotBlank(message = "Username cannot be empty")
    @Size(max = 100, message = "Username must be less than 100 characters")
    private String username;


    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "Email must be valid")
    @NotBlank(message = "Email cannot be empty")
    @Size(max = 100, message = "Email must be less than 100 characters")
    private String email;


    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password cannot be empty")
    @Size(min = 5, max = 100, message = "Password must be between 5 and 100 characters")
    private String password;


    @Column(name = "role", nullable = false)
    @NotNull(message = "Role cannot be null")
    @Enumerated(EnumType.STRING)
    private Role role;


    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;


    // Empty constructor required by JPA
    public User() {
    }


    // Constructor without id and createdAt
    public User(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }


    // Automatically set creation date before saving
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDate.now();
    }


    // Getters and Setters

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public Role getRole() {
        return role;
    }


    public void setRole(Role role) {
        this.role = role;
    }


    public LocalDate getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
