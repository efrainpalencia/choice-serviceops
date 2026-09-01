package com.choice.serviceops.security.persistence;

import com.choice.serviceops.security.domain.EmailAddress;
import com.choice.serviceops.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(EmailAddress email);

    boolean existsByEmail(EmailAddress email);

}
