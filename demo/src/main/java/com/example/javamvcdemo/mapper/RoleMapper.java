package com.example.javamvcdemo.mapper;

import com.example.javamvcdemo.dto.request.PermissionRequest;
import com.example.javamvcdemo.dto.request.RoleRequest;
import com.example.javamvcdemo.dto.response.PermissionResponse;
import com.example.javamvcdemo.dto.response.RoleResponse;
import com.example.javamvcdemo.entity.Permission;
import com.example.javamvcdemo.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);
    RoleResponse toRoleResponse(Role role);
}
