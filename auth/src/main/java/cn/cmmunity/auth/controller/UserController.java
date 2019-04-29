package cn.cmmunity.auth.controller;

import cn.cmmunity.auth.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private UserService userService;

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
