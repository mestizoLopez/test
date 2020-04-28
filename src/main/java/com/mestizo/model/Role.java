package com.mestizo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
public class Role {

    @Id
    private String id;

    private String name;

    private String roleName;

    private String otherValue;

}
