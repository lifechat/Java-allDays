package com.imooc.controller;

import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StuFooController {

    @Autowired
    private StuService stuService;

    @GetMapping(value = "/getStu")
    public Object getStu(int id){
        return stuService.getStuInfo(id);
    }
}
