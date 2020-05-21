package com.mestizo.model.dto;

import com.mestizo.model.Role;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private String id;

    private String name;

    private String lastName;

    private String email;

    private List<Role> roleList;

}
