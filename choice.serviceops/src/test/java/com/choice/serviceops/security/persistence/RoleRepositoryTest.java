package com.choice.serviceops.security.persistence;

import com.choice.serviceops.TestcontainersConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@Import(TestcontainersConfiguration.class)
class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void shouldFindSeededDispatcherRole() {
        var result = roleRepository.findByName("DISPATCHER");

        assertTrue(result.isPresent());
        assertEquals("DISPATCHER", result.get().getName());
    }

    @Test
    void shouldReturnEmptyWhenRoleDoesNotExist() {
        var result = roleRepository.findByName("NON_EXISTENT_ROLE");

        assertFalse(result.isPresent());
    }
}