package com.microservice.transaksi.testMicroservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/transaksi")
public class TransaksiTest {

    @Autowired
    private RestTemplateBuilder restTemplate;

    @GetMapping(value = {"/data", "/data/"})
    public ResponseEntity<Map> getById() {

        Boolean chekBinarfud = callApiBinarfud();
        if(!chekBinarfud){
            Map map = new HashMap();
            map.put("status",404);
            map.put("message","binarfud error");
        }


        Boolean chekSocketio = callApiSocketio();
        if(!chekSocketio){
            Map map = new HashMap();
            map.put("status",404);
            map.put("message","Socketio Error");
        }

        Map map = new HashMap();
        map.put("data","Transaksi Available");
        map.put("status",200);
        map.put("message","success");
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    public Boolean callApiBinarfud(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");


        ResponseEntity<String> exchange = restTemplate.build().exchange("http://localhost:8080/merchants/message", HttpMethod.GET, null, String.class);
        System.out.println("response binarfud  =" + exchange.getBody()); //JACKSON Parsing
        return true;
    }

    public Boolean callApiSocketio(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");


        ResponseEntity<String> exchange = restTemplate.build().exchange("http://localhost:8877/socketio/message", HttpMethod.GET, null, String.class);
        System.out.println("response socketio  =" + exchange.getBody()); //JACKSON Parsing
        return true;
    }
}
