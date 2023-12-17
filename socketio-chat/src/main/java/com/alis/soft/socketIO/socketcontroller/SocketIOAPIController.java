package com.alis.soft.socketIO.socketcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/socketio")
public class SocketIOAPIController {

    @GetMapping(value = {"/message", "/message/"})
    public ResponseEntity<Map> getById() {
        Map map = new HashMap();
        map.put("data","socketio API Available");
        map.put("status",200);
        map.put("message","success");
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

}