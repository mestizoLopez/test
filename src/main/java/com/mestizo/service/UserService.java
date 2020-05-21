package com.mestizo.service;

import com.mestizo.utils.Utils;
import com.mestizo.model.User;
import com.mestizo.model.dto.UserDto;
import com.mestizo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> findAll(){

        return userRepository.findAll()
                .stream()
                .map(user -> Utils.convertToDto(user,UserDto.class))
                .collect(Collectors.toList());
    }

    public String save(UserDto userDto){
        User user = Utils.convertToEntity(userDto,User.class);
        return userRepository.save(user).getId();
    }

}
