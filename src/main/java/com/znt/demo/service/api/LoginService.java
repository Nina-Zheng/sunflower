package com.znt.demo.service.api;


import com.znt.demo.dto.LoginUser;

public interface LoginService {

    /**
     * 根据密码和email查询用户
     * @param loginUser
     * @return
     */
    LoginUser queryByUser(LoginUser loginUser);
}
