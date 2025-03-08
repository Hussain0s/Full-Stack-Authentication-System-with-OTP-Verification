package com.Springboot.login.details.Database.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "login_data")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String password;

    // ✅ Default Constructor (always required by JPA)
    public Login() {}

    // ✅ Add this! Constructor for new user creation (without ID)
    public Login(String email, String name, String phone, String password) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.password = password;
    }

    // (Optional) Full Constructor (with ID) — only if needed for some cases
    public Login(Long id, String email, String name, String phone, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.password = password;
    }

    // ✅ Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "Login [id=" + id + ", email=" + email + ", name=" + name + ", phone=" + phone + ", password=" + password + "]";
    }
}
