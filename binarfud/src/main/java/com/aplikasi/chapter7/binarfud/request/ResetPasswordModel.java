package com.aplikasi.chapter7.binarfud.request;

import lombok.Data;


@Data
public class ResetPasswordModel {
    public String email;
    public String otp;
    public String newPassword;
}

