package com.CentreCulturel.demo.auth;

import com.CentreCulturel.demo.user.UserRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticateRequest {
private String email;
private String password;
}
