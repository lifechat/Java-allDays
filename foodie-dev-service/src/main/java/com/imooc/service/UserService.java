package com.imooc.service;

public interface UserService {
    /**
     * @deprecated  判断用户名是否存在
     * @param  username
     */
    public boolean queryUsernameIsExit(String username);
}
