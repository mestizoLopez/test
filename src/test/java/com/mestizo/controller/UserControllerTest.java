package com.mestizo.controller;

import com.mestizo.model.User;
import com.mestizo.model.dto.UserDto;
import com.mestizo.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @BeforeEach
    public void setUp(){
        Mockito.reset(userService);
    }


    @Test
    public void findAll() throws Exception {
        List<UserDto> list = new ArrayList<>();
        UserDto userDto = new UserDto();
        userDto.setEmail("javier@gmail.com");
        userDto.setName("Javier");
        userDto.setLastName("Lopez");

        list.add(userDto);

        when(userService.findAll()).thenReturn(list);

        mockMvc.perform(get("/user/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].email",is("javier@gmail.com")));

    }

    @Test
    public void save() throws Exception {

        String body = "{\"name\":\"Javier\", \"email\":\"javier@gmail.com\", \"lastName\":\"Lopez\"}";

        UserDto userDto = new UserDto();
        userDto.setEmail("javier@gmail.com");
        userDto.setName("Javier");
        userDto.setLastName("Lopez");
        String expected = "blabla1234";

        when(userService.save(userDto)).thenReturn(expected);

        mockMvc.perform(post("/user")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                //.andExpect(jsonPath("$",hasSize(1)))
                .andExpect(content().string("blabla1234"));

    }

}
