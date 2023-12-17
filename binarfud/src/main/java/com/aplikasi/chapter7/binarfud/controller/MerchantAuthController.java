package com.aplikasi.chapter7.binarfud.controller;

import com.aplikasi.chapter7.binarfud.entity.Merchant;
import com.aplikasi.chapter7.binarfud.repository.MerchantRepository;
import com.aplikasi.chapter7.binarfud.service.MerchantService;
import com.aplikasi.chapter7.binarfud.utils.SimpleStringUtils;
import com.aplikasi.chapter7.binarfud.utils.TemplateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/merchantsAuth")
public class MerchantAuthController {

    @Autowired
    private MerchantService merchantService;
    SimpleStringUtils simpleStringUtils = new SimpleStringUtils();

    @Autowired
    public MerchantRepository merchantRepository;

    @Autowired
    public TemplateResponse response;

    @PutMapping(value ={"/updateStatus", "/updateStatus/"})
    public ResponseEntity<Map> updateMerchantStatus(@RequestBody Merchant request) {
        try {
            return new ResponseEntity<Map>(merchantService.updateMerchantStatus(request), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.Error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
    }

    @PutMapping(value={"/update", "/update/"})
    public ResponseEntity<Map> update(@RequestBody Merchant request) {
        try {
            return new ResponseEntity<Map>(merchantService.update(request), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Map>(response.Error(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR); // 500
        }
    }
}
