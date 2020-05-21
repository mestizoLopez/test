package com.mestizo.service;

import com.mestizo.model.Role;
import com.mestizo.model.dto.RoleDto;
import com.mestizo.repository.RoleRepository;
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
public class RoleServiceTest {

    @MockBean
    private RoleRepository roleRepository;

    @Autowired
    private RoleService roleService;


    @Test
    public void findAll(){

        List<Role> roleList = new ArrayList();
        Role role = new Role();
        role.setId("id1234");
        role.setName("ADMIN");

        roleList.add(role);

        when(roleRepository.findAll()).thenReturn(roleList);
        assertTrue(!roleService.findAll().isEmpty());

    }

    @Test
    public void noneUser(){
        when(roleRepository.findAll()).thenReturn(new ArrayList());
        assertTrue(roleService.findAll().isEmpty());
        verify(roleRepository,times(1)).findAll();
    }

    @Test
    public void save(){
        Role role = new Role();
        role.setId("id1234");
        role.setName("ADMIN");
        when(roleRepository.save(any())).thenReturn(role);

        RoleDto roleDto = new RoleDto();
        roleDto.setId("id1234");
        roleDto.setName("ADMIN");
        assertEquals(roleService.save(roleDto),"id1234");
    }

}
