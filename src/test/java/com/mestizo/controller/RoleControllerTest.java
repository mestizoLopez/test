package com.mestizo.controller;

import com.mestizo.model.Role;
import com.mestizo.model.User;
import com.mestizo.model.dto.RoleDto;
import com.mestizo.repository.RoleRepository;
import com.mestizo.service.RoleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoleController.class)
public class RoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoleService roleService;

    @BeforeEach
    public void setUp(){
        Mockito.reset(roleService);
    }

    @Test
    public void findAll() throws Exception {

        List<RoleDto> roleDtos = new ArrayList<>();
        RoleDto role = new RoleDto();
        role.setName("ADMIN");
        roleDtos.add(role);

        when(roleService.findAll()).thenReturn(roleDtos);

        mockMvc.perform(get("/role").accept(APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name",is("ADMIN")))
                .andExpect(jsonPath("$",hasSize(1)));


    }

    @Test
    public void save() throws Exception {

        RoleDto roleDto = new RoleDto();
        roleDto.setName("ADMIN");
        String roleBody = "{\"name\":\"ADMIN\"}";

        mockMvc.perform(post("/role")
                .content(roleBody)
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

}
