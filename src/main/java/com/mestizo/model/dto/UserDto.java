package com.mestizo.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class UserDto {

    private String id;

    private String name;

    private String lastName;

    private String email;

    private String roleName;

    private String otherValue;

}
