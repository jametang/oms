package com.zjjc.oms;

import com.zjjc.oms.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserLoginMapper {
    public List<UserLogin> queryAll();
    public int add(UserLogin userLogin);

    public UserLogin queryByName(String username);
}
