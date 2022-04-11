package com.imooc.controller;


import com.immoc.utils.JsonResult;
import com.imooc.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.StringUtil;

@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @GetMapping("/usernameIsExist")
    public JsonResult usernameIsExist(@RequestParam String username){

//        判断用户名不能为空
        if(!StringUtils.isNotBlank(username)){
            return JsonResult.errorMsg("用户名不能为空");
        }
        //查找用户是否存在
        boolean isExit = userService.queryUsernameIsExit(username);
        if(isExit){
            return JsonResult.errorMsg("用户名已经存在");
        }
//        请求成功，用户名没有重复
        return JsonResult.ok("用户名没有重复");
    }
}
