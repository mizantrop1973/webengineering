package com.java.webengineering;

import com.java.webengineering.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.List;

@Controller
public class MainController {

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
        Collection<User> users = List.of(
                new User("John", "Smith", "www@qqq.com"),
                new User("Mike", "Johnson", "qqq@qqq.com")
        );

        model.addAttribute("users", users);
        return "users";

    }

}
