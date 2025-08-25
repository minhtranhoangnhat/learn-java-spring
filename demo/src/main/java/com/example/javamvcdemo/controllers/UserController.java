package com.example.javamvcdemo.controllers;

import com.example.javamvcdemo.dto.response.APIResponse;
import com.example.javamvcdemo.dto.request.UserCreationRequest;
import com.example.javamvcdemo.dto.request.UserUpdateRequest;
import com.example.javamvcdemo.dto.response.UserResponse;
import com.example.javamvcdemo.models.User;
import com.example.javamvcdemo.services.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserController {
    UserService userService;

    @PostMapping
    public APIResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        APIResponse<User> apiResponse = new APIResponse<>();

        apiResponse.setCode(1000);
        apiResponse.setResult(userService.createRequest(request));
        return apiResponse;
    }

    @GetMapping
    public APIResponse<List<UserResponse>> getUsers(){
        //lấy ttin người đăng nhập từ security context
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("Username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));

        return APIResponse.<List<UserResponse>>builder()
                .result(userService.getUsers())
                .build();
    }

    @GetMapping("/{userId}")
    public APIResponse<UserResponse> getUser(@PathVariable("userId") String userId){
        return APIResponse.<UserResponse>builder()
                .result(userService.getUser(userId))
                .build();
    }

    @GetMapping("/myInfo")
    public APIResponse<UserResponse> getMYInfo(){
        return APIResponse.<UserResponse>builder()
                .result(userService.getMyInfo())
                .build();
    }

    @PutMapping("/{userId}")
    public APIResponse<UserResponse> updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest userUpdateRequest){
        return APIResponse.<UserResponse>builder()
                .result(userService.updateUser(userId,userUpdateRequest))
                .build();
    }

    @DeleteMapping("/{userId}")
    public APIResponse<String> deleteUser(@PathVariable String userId){
        return APIResponse.<String>builder()
                .result("User has been deleted!")
                .build();
    }
}
