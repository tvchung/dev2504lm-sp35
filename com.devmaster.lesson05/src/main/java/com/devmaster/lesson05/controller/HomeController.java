package com.devmaster.lesson05.controller;

import com.devmaster.lesson05.entity.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping
public class HomeController {
    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model){
        List<user> users = new ArrayList<>();
        users.add(new user("Chung","ChungChung","123123","chungtrinhj@gmail.com"));
        users.add(new user("Devmaster","dev123","123123","contact@devmaster.edu.vn"));
        model.addAttribute("users", users);
        return "profile";
    }
}
