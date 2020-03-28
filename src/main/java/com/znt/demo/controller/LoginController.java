package com.znt.demo.controller;

import com.znt.demo.dto.LoginUser;
import com.znt.demo.service.api.LoginService;
import com.znt.demo.util.LoginCacheUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Resource
    LoginService loginService;

    @PostMapping("/login")
    public LoginUser doLogin(LoginUser loginUser, HttpSession session, HttpServletResponse response){
        LoginUser loginUser1 = loginService.queryByUser(loginUser);
        if(loginUser1 ==null) {
            session.setAttribute("msg","用户名和密码错误");
        }else{
            //保存用户登录信息
            String token = UUID.randomUUID().toString();
            //设置携带用户信息的cookie
            Cookie cookie = new Cookie("TOKEN",token);
            cookie.setDomain("sunflower.com");
            response.addCookie(cookie);
            LoginCacheUtil.loginUser.put(token, loginUser1);
        }
        return loginUser1;
    }

}
