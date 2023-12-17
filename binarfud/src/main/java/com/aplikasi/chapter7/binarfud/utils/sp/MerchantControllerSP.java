package com.aplikasi.chapter7.binarfud.utils.sp;

import com.aplikasi.chapter7.binarfud.repository.MerchantRepository;
import com.aplikasi.chapter7.binarfud.service.MerchantService;
import com.aplikasi.chapter7.binarfud.utils.SimpleStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/merchant/sp")
public class MerchantControllerSP {
    @Autowired
    public MerchantService merchantService;

    SimpleStringUtils simpleStringUtils = new SimpleStringUtils();
    @Autowired
    private DataSource dataSource;
    @Autowired
    public MerchantRepository merchantRepository;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<Map> getById() {
        Map map = new HashMap();
        map.put("list",merchantRepository.getListSP());
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }
}


