package com.mestizo.service;

import com.mestizo.model.dto.UserDto;
import com.mestizo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> findAll(){

        List<UserDto> userDtos= userRepository.findAll()
                .stream()
                .map(user ->{
                    UserDto userDto = new UserDto();
                     BeanUtils.copyProperties(userDto,user);
                    return userDto;
                })
                .collect(Collectors.toList());

        return userDtos;
    }

}
