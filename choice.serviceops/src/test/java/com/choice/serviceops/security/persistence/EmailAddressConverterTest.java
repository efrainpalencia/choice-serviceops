package com.choice.serviceops.security.persistence;

import com.choice.serviceops.security.domain.EmailAddress;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class EmailAddressConverterTest {

    private final EmailAddressConverter converter = new EmailAddressConverter();

    @Test
    void shouldConvertEmailAddressToDatabaseValue() {
        EmailAddress email = new EmailAddress("user@example.com");

        String result = converter.convertToDatabaseColumn(email);

        assertEquals("user@example.com", result);
    }

    @Test
    void shouldConvertDatabaseValueToEmailAddress() {
        EmailAddress result = converter.convertToEntityAttribute("USER@EXAMPLE.COM");

        assertEquals("user@example.com", result.value());
    }

    @Test
    void shouldHandleNullDomainValue() {

        assertNull(converter.convertToDatabaseColumn(null));
    }

    @Test
    void shouldHandleNullDatabaseValue() {

        assertNull(converter.convertToEntityAttribute(null));
    }
}
