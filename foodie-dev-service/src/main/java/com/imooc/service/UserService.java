package com.imooc.service;

import com.imooc.pojo.Users;
import com.imooc.pojo.bo.UserBO;

public interface UserService {
    /**
     * @deprecated  判断用户名是否存在
     * @param  username
     */
    public boolean queryUsernameIsExit(String username);

    /**
     *
     * @param userBO
     * @return
     * @deprecated  注册用户接口
     */
    public Users createUser(UserBO userBO);
}
