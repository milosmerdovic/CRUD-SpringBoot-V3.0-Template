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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        PageRequest pageable = PageRequest.of(0, 10, Sort.by("id"));
        Page<User> result = userService.getUsers(pageable);

        assertThat(result).isNotNull();

        assertThat(result).isNotEmpty();

        assertThat(result.getContent().get(0).getName()).isEqualTo("John");
    }


}
