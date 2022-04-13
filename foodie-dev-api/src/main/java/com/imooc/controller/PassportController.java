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

        if(!StringUtils.isNotBlank(username)){
            return JsonResult.errorMsg("用户名不能为空");
        }
        boolean isExit = userService.queryUsernameIsExit(username);
        if(isExit){
            return JsonResult.errorMsg("用户名已经存在");
        }
        return JsonResult.ok("用户名没有重复");
    }

    @PostMapping("/regist")
    public JsonResult regist(@RequestBody UserBO userBO){

        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();

        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password) ||
                StringUtils.isBlank(confirmPwd)) {
            return JsonResult.errorMsg("用户名或密码不能为空");
        }

        boolean isExist = userService.queryUsernameIsExit(username);
        if (isExist) {
            return JsonResult.errorMsg("用户名已经存在");
        }

        if (password.length() < 6) {
            return JsonResult.errorMsg("密码长度不能少于6");
        }

        if (!password.equals(confirmPwd)) {
            return JsonResult.errorMsg("两次密码输入不一致");
        }

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
