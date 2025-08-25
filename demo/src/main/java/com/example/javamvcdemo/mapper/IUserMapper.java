package com.example.javamvcdemo.mapper;

import com.example.javamvcdemo.dto.request.UserCreationRequest;
import com.example.javamvcdemo.dto.request.UserUpdateRequest;
import com.example.javamvcdemo.dto.response.UserResponse;
import com.example.javamvcdemo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    User toUser(UserCreationRequest request); //nhận vào tham số kiểu UserCreationRequest và trả về User

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
    UserResponse toUserResponse(User user);
}
