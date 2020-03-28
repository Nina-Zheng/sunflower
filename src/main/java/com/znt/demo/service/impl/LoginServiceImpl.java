package com.znt.demo.service.impl;

import com.znt.demo.dao.entity.User;
import com.znt.demo.dao.entity.UserExample;
import com.znt.demo.dao.mapping.UserMapper;
import com.znt.demo.dto.LoginUser;
import com.znt.demo.service.api.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    UserMapper userMapper;

    public LoginUser queryByUser(LoginUser loginUser){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andPasswordEqualTo(loginUser.getPassword())
                .andNameEqualTo(loginUser.getName());
        List<User> users = userMapper.selectByExample(userExample);
        if(users.isEmpty()){
            return new LoginUser();
        }
        LoginUser user = new LoginUser();
        user.setId(users.get(0).getId());
        user.setEmail(users.get(0).getEmail());
        user.setName(users.get(0).getName());
        return user;
    }
}
