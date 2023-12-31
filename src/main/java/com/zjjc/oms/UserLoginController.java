package com.zjjc.oms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserLoginController {
    @Autowired
    UserLoginServicesImpl userLoginServicesImpl;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/LoginSuccess")
    public String LoginSuccess(Model model, UserLogin userLogin){
        //先查询看该用户名是否存在
        UserLogin userLogin1 = userLoginServicesImpl.queryByName(userLogin.getUsername());
        if(userLogin1 != null){ //  如果查询的用户不为空
            System.out.println(userLogin1.toString());
            return "success";
        }
        else{
            //返回到登录页面
            model.addAttribute("data","该用户不存在，请先注册");
            return "login";
        }
    }
    //登录界面
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }
    @RequestMapping("/RegisterSuccess")
    public String toRegisterSuccess(Model model,UserLogin userLogin){
        //将账号密码加入到数据库中
        int add = userLoginServicesImpl.add(userLogin);
        if (add < 1) {
            System.out.println("数据插入失败！");
            return  "failed";
        } else {
            System.out.println("数据插入成功！");
            model.addAttribute("data","注册成功，请登录！");
            return "login";
        }
    }
    @RequestMapping("/Test")
    public String test(Model model){
        List<UserLogin> list = userLoginServicesImpl.queryAll();
        model.addAttribute("userList", list);
        list.forEach(System.out::println);
        return "test";
    }
}
