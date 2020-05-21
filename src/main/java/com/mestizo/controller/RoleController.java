package com.mestizo.controller;

import com.mestizo.model.Role;
import com.mestizo.model.dto.RoleDto;
import com.mestizo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RoleDto> findAll(){
        return roleService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody RoleDto roleDto){
        return roleService.save(roleDto);
    }

}
