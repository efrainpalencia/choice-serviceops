package com.choice.serviceops.security.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordPolicyTest {

    @Test
    void shouldAcceptValidPassword() {
        assertDoesNotThrow(() -> PasswordPolicy.validate("ValidPassword123!"));
    }

    @Test
    void shoulRejectNullPassword() {
        assertThrows(IllegalArgumentException.class, () -> PasswordPolicy.validate(null));
    }

    @Test
    void shouldRejectBlankPassword() {
        assertThrows(IllegalArgumentException.class, () -> PasswordPolicy.validate("  "));
    }

    @Test
    void shouldRejectShorterThanMinimumLengthPassword() {
        assertThrows(IllegalArgumentException.class, () -> PasswordPolicy.validate("Short1!"));
    }

    @Test
    void shouldRejectLongerThanMaximumLengthPassword() {
        String password = "a".repeat(73);

        assertThrows(IllegalArgumentException.class, () -> PasswordPolicy.validate(password));
    }
}
