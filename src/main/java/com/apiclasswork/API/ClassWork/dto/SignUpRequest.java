package com.apiclasswork.API.ClassWork.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    private String fullName;
    private String username;
    private String email;
    private String password;
}
