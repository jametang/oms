package com.zjjc.oms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserLoginServicesImpl implements UserLoginServicesI{
    @Autowired
    UserLoginMapper userLoginMapper;
    @Override
    public List<UserLogin> queryAll() {
        return userLoginMapper.queryAll();
    }

    @Override
    public int add(UserLogin userLogin) {
        return userLoginMapper.add(userLogin);
    }

    @Override
    public UserLogin queryByName(String username) {
        return userLoginMapper.queryByName(username);
    }
}
