package com.java.webengineering;

import com.java.webengineering.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    static List<User> users = new ArrayList<>();


   /* @GetMapping("/")
    public String view(@RequestParam(value = "name",
            required = false, defaultValue = "stranger") String name, Model model){
        model.addAttribute("msg", "Hello, " + name);*/

     //OR   (name is necessary)
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
    public String getUsers (Model model) {
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/users/new")
    public String getSignUp(Model model) {
        model.addAttribute("user", new User());
        return "sign_up";
    }

    @PostMapping("/users/new")
    public String SignUp(/*@RequestParam("name") String name,
                         @RequestParam("surname") String surname,
                         @RequestParam("email") String email*/
                         @ModelAttribute @Valid User user, BindingResult result) {
        if(result.hasErrors()){
            return "/sign_up";
        }
        users.add(/*new User(name, surname, email)*/user);
        return "redirect:/users";

    }

}
