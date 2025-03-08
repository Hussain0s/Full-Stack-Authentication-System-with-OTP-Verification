package com.Springboot.login.details.Database.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Springboot.login.details.Database.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Optional<Login> findByEmail(String email);
}
