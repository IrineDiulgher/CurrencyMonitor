package com.currency.monitor.services;

import com.currency.monitor.datasource.UserDAO;
import com.currency.monitor.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UsersServiceTest {

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UsersService usersService;
    @Test
    void createUser() {
        when(userDAO.save(any(User.class))).thenReturn(new User());
        User created = usersService.createUser("username","password",
                "email", "phoneNumber", "password");
        assertThat(created).isNotNull();
    }
}