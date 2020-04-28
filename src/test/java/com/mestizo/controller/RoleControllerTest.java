package com.mestizo.controller;

import com.mestizo.model.Role;
import com.mestizo.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest
public class RoleControllerTest {

    @MockBean
    private RoleRepository roleRepository;

    @BeforeEach
    public void setUp(){
        Mockito.reset(roleRepository);
    }

    @Test
    public void justTest(){

        List<Role> list = new ArrayList();

        Role role = new Role("1","","","");
        list.add(role);

        when(roleRepository.findAll()).thenReturn(list);


    }

}
