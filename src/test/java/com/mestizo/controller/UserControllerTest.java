package com.mestizo.controller;

import com.mestizo.model.dto.UserDto;
import com.mestizo.service.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest
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


                /*
                .andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].id", is(2)))
				.andExpect(jsonPath("$[0].comment", is("comment content")))
				.andExpect(jsonPath("$[0].author", is("John Smith")))
				.andExpect(jsonPath("$[0].creationDate", is(creationDate.toString())));
                 */


    }

}
