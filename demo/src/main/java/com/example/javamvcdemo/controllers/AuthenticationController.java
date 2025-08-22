package com.example.javamvcdemo.controllers;

import com.example.javamvcdemo.dto.request.APIResponse;
import com.example.javamvcdemo.dto.request.AuthenticationRequest;
import com.example.javamvcdemo.dto.response.AuthenticationResponse;
import com.example.javamvcdemo.services.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/log-in")
    APIResponse<AuthenticationResponse> authenticate (@RequestBody AuthenticationRequest request){
        boolean result = authenticationService.authenticate(request);
        return APIResponse.<AuthenticationResponse>builder()
                .result(AuthenticationResponse.builder().isAuthenticated(result)
                        .build())
                .build();
    }
}
