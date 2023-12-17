package com.aplikasi.chapter7.binarfud.service.oauth;


import com.aplikasi.chapter7.binarfud.request.LoginModel;
import com.aplikasi.chapter7.binarfud.request.RegisterMerchantModel;

import java.util.Map;

public interface MerchantOauthService {
    Map registerManual(RegisterMerchantModel objModel) ;

    Map registerByGoogle(RegisterMerchantModel objModel) ;

    public Map login(LoginModel objLogin);
}




