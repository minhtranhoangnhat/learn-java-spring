package com.example.javamvcdemo.controllers;

import com.example.javamvcdemo.dto.request.PermissionRequest;
import com.example.javamvcdemo.dto.request.RoleRequest;
import com.example.javamvcdemo.dto.response.APIResponse;
import com.example.javamvcdemo.dto.response.PermissionResponse;
import com.example.javamvcdemo.dto.response.RoleResponse;
import com.example.javamvcdemo.entity.Role;
import com.example.javamvcdemo.services.PermissionService;
import com.example.javamvcdemo.services.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleController {
    RoleService roleService;

    @PostMapping
    APIResponse<RoleResponse> create(@RequestBody RoleRequest request){
        return APIResponse.<RoleResponse>builder()
                .result(roleService.create(request))
                .build();
    }

    @GetMapping
    APIResponse<List<RoleResponse>> getAll(){
        return APIResponse.<List<RoleResponse>>builder()
                .result(roleService.getAll())
                .build();
    }

    @DeleteMapping("/{permission}")
    APIResponse<Void> delete (@PathVariable String permission){
        roleService.delete(permission);
        return APIResponse.<Void>builder().build();
    }
}
