package com.mestizo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class User {

    @Id
    private String id;

    private String name;

    private String lastName;

    private String email;

    private String password;

    //@DBRef
    private List<Role> roleList;

}
