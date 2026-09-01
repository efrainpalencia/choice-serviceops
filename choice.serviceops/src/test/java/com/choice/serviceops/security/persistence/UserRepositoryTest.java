package com.choice.serviceops.security.persistence;

import com.choice.serviceops.TestcontainersConfiguration;
import com.choice.serviceops.security.domain.EmailAddress;
import com.choice.serviceops.security.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@Import(TestcontainersConfiguration.class)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldSaveAndFindUserByEmail() {
        EmailAddress email = new EmailAddress("USER@EXAMPLE.COM");

        User user = new User(
                email,
                "{bcrypt}hashed-password",
                "John",
                "Doe");

        userRepository.saveAndFlush(user);

        var result = userRepository.findByEmail(
                new EmailAddress("user@example.com"));

        assertTrue(result.isPresent());
        assertTrue(
                result.get()
                        .getEmail()
                        .equals(new EmailAddress("user@example.com")));
    }

    @Test
    void shouldReportWhetherEmailExists() {
        EmailAddress email = new EmailAddress("john@example.com");

        assertFalse(userRepository.existsByEmail(email));

        userRepository.saveAndFlush(
                new User(
                        email,
                        "{bcrypt}hashed-password",
                        "John",
                        "Doe"));

        assertTrue(userRepository.existsByEmail(email));
    }
}