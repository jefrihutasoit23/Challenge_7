package com.aplikasi.chapter7.binarfud.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
@Data
public class RegisterUserModel {
    @NotEmpty(message = "username is required.")
    private String username;

    @NotEmpty(message = "password is required.")
    private String password;

    @NotEmpty(message = "fullname is required.")
    private String fullname;

    private String alamat;

    private String jenis_kelamin;
}


