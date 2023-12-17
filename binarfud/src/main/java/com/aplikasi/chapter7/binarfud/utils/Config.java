package com.aplikasi.chapter7.binarfud.utils;

import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

@Data
public class Config {
    String code = "status", message = "message";
    public String code_notFound ="404";

    public String codeRequired ="403";
    public String isRequired =" is Required";

    public String code_sukses = "200";
    public String code_server = "500";
    public String code_null = "1";
    public String message_sukses = "sukses";
    public static Integer  EROR_CODE_404 =404;
    public  static  String NAME_REQUIRED = "Name is Required.";

    public  static  String ID_REQUIRED = "Id is Required.";

    public  static  String USERNAME_REQUIRED = "Username is Required.";

    public  static  String MERCHANT_NAME_REQUIRED = "merchant name is Required.";

    public  static  String MERCHANT_REQUIRED = "Merchant is Required.";

    public  static  String MERCHANT_NOT_FOUND = "MERCHANT not found.";

    public  static  String ORDER_REQUIRED = "Order is Required.";

    public  static  String ORDER_NOT_FOUND = "ORDER not found.";

    public  static  String ORDER_DETAIL_REQUIRED = "Order Detail is Required.";

    public  static  String ORDER_DETAIL_NOT_FOUND = "ORDER detail not found.";

    public  static  String PRODUCT_REQUIRED = "Product is Required.";

    public  static  String PRODUCT_NOT_FOUND = "PRODUCT not found.";

    public  static  String USER_REQUIRED = "USER is Required.";

    public  static  String USER_NOT_FOUND = "USER not found.";

    public  static  String SUCCESS = "Success.";

    public String convertDateToString(Date date) {

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String strDate = dateFormat.format(date);
        return strDate;
    }
    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }
}

