package com.imooc.controller;


import com.immoc.utils.JsonResult;
import com.imooc.pojo.bo.UserBO;
import com.imooc.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/regist")
    public JsonResult regist(@RequestBody UserBO userBO){

        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();

        // 0. 判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password) ||
                StringUtils.isBlank(confirmPwd)) {
            return JsonResult.errorMsg("用户名或密码不能为空");
        }

        // 1. 查询用户名是否存在
        boolean isExist = userService.queryUsernameIsExit(username);
        if (isExist) {
            return JsonResult.errorMsg("用户名已经存在");
        }

        // 2. 密码长度不能少于6位
        if (password.length() < 6) {
            return JsonResult.errorMsg("密码长度不能少于6");
        }

        // 3. 判断两次密码是否一致
        if (!password.equals(confirmPwd)) {
            return JsonResult.errorMsg("两次密码输入不一致");
        }

        // 4. 实现注册
        userService.createUser(userBO);

//        userResult = setNullProperty(userResult);
//
//        CookieUtils.setCookie(request, response, "user",
//                JsonUtils.objectToJson(userResult), true);

        // TODO 生成用户token，存入redis会话
        // TODO 同步购物车数据

        return JsonResult.ok("注册成功");
    }
}
