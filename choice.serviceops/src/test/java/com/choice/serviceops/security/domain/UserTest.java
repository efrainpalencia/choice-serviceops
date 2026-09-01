package com.choice.serviceops.security.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    @Test
    void shouldCreateActiveUserwithEmailAddress() {
        EmailAddress email = new EmailAddress("USER@EXAMPLE.COM");

        User user = new User(
                email,
                "{bcrypt}hashed-password",
                "John",
                "Doe");

        assertEquals("user@example.com", user.getEmail().value());
        assertEquals("{bcrypt}hashed-password", user.getPasswordHash());
        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals(UserStatus.ACTIVE, user.getStatus());

        assertNotNull(user.getCreatedAt());
        assertNotNull(user.getUpdatedAt());

        assertTrue(user.getRoles().isEmpty());
    }
}
