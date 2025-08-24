package com.example.javamvcdemo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)//bỏ qua dữ liệu trả về null
public class APIResponse <T>{
    private int code = 1000;
    private String message;
    private T result;
}
