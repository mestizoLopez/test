package com.mestizo.service;

import com.mestizo.model.User;
import com.mestizo.model.dto.UserDto;
import com.mestizo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void findAll() throws Exception {

        List<User> userList = new ArrayList();
        User user = new User();
        user.setEmail("javier@gmail.com");
        user.setName("Javier");
        user.setLastName("Lopez");
        userList.add(user);

        when(userRepository.findAll()).thenReturn(userList);
        assertTrue(!userService.findAll().isEmpty());
    }

    @Test
    public void noneUser(){
        when(userRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(userService.findAll().isEmpty());
        verify(userRepository,times(1)).findAll();
    }

    @Test
    public void save(){
        User user = new User();
        user.setId("id1234");
        user.setEmail("javier@gmail.com");
        user.setName("Javier");
        user.setLastName("Lopez");
        String expected = "id1234";

        when(userRepository.save(any())).thenReturn(user);

        UserDto userDto = new UserDto();
        userDto.setId("id1234");
        userDto.setEmail("javier@gmail.com");
        userDto.setName("Javier");
        userDto.setLastName("Lopez");

        assertEquals(userService.save(userDto),expected);
    }

}
