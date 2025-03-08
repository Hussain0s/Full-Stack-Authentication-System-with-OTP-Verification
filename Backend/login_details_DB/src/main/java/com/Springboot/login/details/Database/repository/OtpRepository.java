package com.Springboot.login.details.Database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Springboot.login.details.Database.entity.OtpDetails;
import java.util.Optional;

public interface OtpRepository extends JpaRepository<OtpDetails, Long> {
    Optional<OtpDetails> findByEmail(String email);
}
