package com.org.controller;

import com.org.pojo.User;
import com.org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/oa")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String myUser(Model model){
        List<User> list = userService.list();
        model.addAttribute("myuser",list);
        return "user";

    }

    @GetMapping("/showLogin")
    public String showLogin(){
        return "login";
    }

    @GetMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request){
        if ("lkw".equalsIgnoreCase(name) && "123".equalsIgnoreCase(pwd)){
//            在session中存储用户信息，用于进行权限验证
            request.getSession().setAttribute("users",name);
            return "user";
        }else {
            request.setAttribute("x","用户名或密码不正确");
            return "login";
        }
    }


}
