package com.laba.productapi.mapper;

import com.laba.productapi.Dto.UserSaveRequestDto;
import com.laba.productapi.Entity.Users;
import com.laba.productapi.Entity.Product;

import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface UserMapper {

    Users userSaveRequestDtoToUser(UserSaveRequestDto userSaveRequestDto);



}
