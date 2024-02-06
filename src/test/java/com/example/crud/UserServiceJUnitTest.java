package com.example.crud;

import com.example.crud.entity.User;
import com.example.crud.repository.UserRepository;
import com.example.crud.service.UserService;
import com.example.crud.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("postgres")
public class UserServiceJUnitTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetAllUsers() {
        // Pozivamo servis da dobijemo listu svih korisnika
        List<User> result = userService.getUsers();

        // Proveravamo da li je rezultat null
        assertThat(result).isNotNull();

        // Proveravamo da li je lista prazna (očekujemo da ne bude)
        assertThat(result).isNotEmpty();

        // Proveravamo neke karakteristike korisnika, na primer, da li je ime prvog korisnika "John"
        assertThat(result.get(0).getName()).isEqualTo("John");
    }


}