package com.immoc.controller;

import com.imooc.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StuFooController {

    @Autowired()
    private StuService stuService;

    @RequestMapping(value = "/getStu",method = RequestMethod.GET)
    public Object getStu(int id){
        return stuService.getStuInfo(id);
    }
}
