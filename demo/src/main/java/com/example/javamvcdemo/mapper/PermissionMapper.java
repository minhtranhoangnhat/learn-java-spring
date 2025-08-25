package com.example.javamvcdemo.mapper;

import com.example.javamvcdemo.dto.request.PermissionRequest;
import com.example.javamvcdemo.dto.request.UserCreationRequest;
import com.example.javamvcdemo.dto.request.UserUpdateRequest;
import com.example.javamvcdemo.dto.response.PermissionResponse;
import com.example.javamvcdemo.dto.response.UserResponse;
import com.example.javamvcdemo.entity.Permission;
import com.example.javamvcdemo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest permissionRequest);
    PermissionResponse toPermissionResponse(Permission permission);
}
