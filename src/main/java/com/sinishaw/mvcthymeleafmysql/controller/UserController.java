package com.sinishaw.mvcthymeleafmysql.controller;

import com.sinishaw.mvcthymeleafmysql.model.User;
import com.sinishaw.mvcthymeleafmysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
        System.out.println("******************");
    }

    @GetMapping("/index")
    public String home(Model model){
        System.out.println("*******HOME***********");
        model.addAttribute("users", userService.listAllUsers());
        return "index";
    }

    @GetMapping("/signup")
    public String showSignUp(User user){
        return "addusers";
    }

    @PostMapping(value = "/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model){
//        if(result.hasErrors()){
//            return "addusers";
//        }
        userService.addUser(user);
        System.out.println("*******Added User***********");
        model.addAttribute("users", userService.listAllUsers());
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        User user = userService.findUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "updateuser";
    }

    @PostMapping(value = "/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "updateuser";
        }

        userService.addUser(user);
        model.addAttribute("users", userService.listAllUsers());
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        User user = userService.findUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userService.delete(id);
        model.addAttribute("users", userService.listAllUsers());
        return "index";
    }

}