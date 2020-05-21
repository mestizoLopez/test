package com.mestizo.service;

import com.mestizo.utils.Utils;
import com.mestizo.model.Role;
import com.mestizo.model.dto.RoleDto;
import com.mestizo.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RoleService {


    @Autowired
    private RoleRepository roleRepository;

    public List<RoleDto> findAll(){

        return roleRepository.findAll().stream()
                .map(role -> Utils.convertToDto(role,RoleDto.class))
                .collect(Collectors.toList());
    }

    public String save(RoleDto roleDto) {
        Role role = Utils.convertToEntity(roleDto,Role.class);
        return roleRepository.save(role).getId();
    }

}
