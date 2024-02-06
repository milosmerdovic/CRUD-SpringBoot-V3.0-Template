package com.example.crud;

import com.example.crud.entity.User;
import com.example.crud.repository.UserRepository;
import com.example.crud.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceMockitoTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void testGetAllUsersWithMock() {
        // Mockujemo repozitorijum da vrati listu korisnika
        User user1 = new User(1l,"John", "Doe");
        User user2 = new User(2l,"Jane", "Smith");
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        // Pozivamo servis za dobijanje svih korisnika
        List<User> result = userService.getUsers();

        // Proveravamo da li je rezultat jednak mockovanoj listi korisnika
        assertThat(result).contains(user1, user2);
    }
}
