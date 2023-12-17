package com.aplikasi.chapter7.binarfud.service.oauth;


import com.aplikasi.chapter7.binarfud.request.LoginModel;
import com.aplikasi.chapter7.binarfud.request.RegisterUserModel;

import java.util.Map;

public interface UserService {
    Map registerManual(RegisterUserModel objModel) ;

    Map registerByGoogle(RegisterUserModel objModel) ;

    public Map login(LoginModel objLogin);
}




