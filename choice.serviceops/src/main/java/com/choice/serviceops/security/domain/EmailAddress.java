package com.choice.serviceops.security.domain;

import java.util.Locale;
import java.util.regex.Pattern;

public record EmailAddress(String value) {
    private static final int MAX_LENGTH = 255;

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");

    public EmailAddress {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Email address is required.");
        }

        String normalized = value.trim().toLowerCase(Locale.ROOT);

        if (normalized.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Email address must not exceed " + MAX_LENGTH + " characters.");
        }

        if (!EMAIL_PATTERN.matcher(normalized).matches()) {
            throw new IllegalArgumentException("Invalid email address format.");
        }

        value = normalized;
    }
}
