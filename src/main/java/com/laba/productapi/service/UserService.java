package com.laba.productapi.service;

import com.laba.productapi.Dto.UserSaveRequestDto;
import com.laba.productapi.Entity.Users;
import com.laba.productapi.mapper.UserMapper;
import com.laba.productapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void save(UserSaveRequestDto userSaveRequestDto) {
        Users users = userMapper.userSaveRequestDtoToUser(userSaveRequestDto);
        userRepository.save(users);
    }

    public Optional<Users> findUserById(Long id){
        return userRepository.findById(id);
    }

}
