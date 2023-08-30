package com.java.webengineering.controller;

import com.java.webengineering.model.User;
import com.java.webengineering.service.UserService;
import com.java.webengineering.util.UserValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

   // static List<User> users = new ArrayList<>();

   /*@GetMapping("/")
    public String view(@RequestParam(value = "name",
            required = false, defaultValue = "stranger") String name, Model model){
        model.addAttribute("msg", "Hello, " + name);*/

    //      OR   (name is necessary)
    @GetMapping("/{name}")
    public String view(@PathVariable("name") String name, Model model){
        model.addAttribute("msg", "Hello, " + name);
        return "index";
    }

    @GetMapping("/raw")
    @ResponseBody
    public String raw() {
        return "Raw data";
    }

    @GetMapping("/users")
    public String getUsers (Model model) throws SQLException {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("/users/new")
    public String getSignUp(Model model) {
        model.addAttribute("user", new User());
        return "sign_up";
    }

    @PostMapping("/users/new")
    public String SignUp(@ModelAttribute @Valid User user, BindingResult result) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "sign_up";
        }
        userService.add(user);
        return "redirect:/users";
    }
}