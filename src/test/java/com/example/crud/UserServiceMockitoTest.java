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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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
        User user1 = new User(1l,"John", "Doe");
        User user2 = new User(2l,"Jane", "Smith");
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));
        PageRequest pageable = PageRequest.of(0,10, Sort.by("id"));
        Page<User> result = userService.getUsers(pageable);

        assertThat(result).contains(user1, user2);
    }
}
