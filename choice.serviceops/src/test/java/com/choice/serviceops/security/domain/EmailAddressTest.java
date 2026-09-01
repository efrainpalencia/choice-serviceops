package com.choice.serviceops.security.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailAddressTest {
    @Test
    void shouldCreateValidEmailAddress() {
        EmailAddress email = new EmailAddress("user@example.com");

        assertEquals("user@example.com", email.value());
    }

    @Test
    void shouldNormalizeEmailAddress() {
        EmailAddress email = new EmailAddress(" USER@EXAMPLE.COM ");

        assertEquals("user@example.com", email.value());
    }

    @Test
    void shouldRejectNullEmailAddress() {
        assertThrows(IllegalArgumentException.class, () -> new EmailAddress(null));
    }

    @Test
    void shouldRejectBlankEmailAddress() {
        assertThrows(IllegalArgumentException.class, () -> new EmailAddress("  "));
    }

    @Test
    void shouldRejectMalformedEmailAddress() {
        assertThrows(IllegalArgumentException.class, () -> new EmailAddress("not-an-email"));
    }

    @Test
    void shouldRejectEmailAddressExceedingMaxLength() {
        String email = "a".repeat(245) + "@example.com";

        assertThrows(IllegalArgumentException.class, () -> new EmailAddress(email));
    }
}
