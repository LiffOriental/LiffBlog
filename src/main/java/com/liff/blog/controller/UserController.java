package com.liff.blog.controller;

import com.liff.blog.pojo.User;
import com.liff.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/tologin")
    public String tologin(Model model){

        return "login";
    }

    @RequestMapping("/toregister")
    public String toregister(){
        return "register";
    }
    @ResponseBody
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public Object login(@RequestBody Map<String,String> reqMap, Model model, HttpSession session){


        User user = userService.findUserByEmail(reqMap.get("email"));
        if(user == null){
            return 0;
        }else if(user.getPassword().equals(reqMap.get("password"))){

            session.setAttribute("loginUser",user.getUsername());
            model.addAttribute("loginUser",user.getUsername());

//            return user.getUsername();
            return user;
        }else{
            return 2;
        }

    }


}
