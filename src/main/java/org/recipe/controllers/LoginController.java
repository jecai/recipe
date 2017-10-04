package org.recipe.controllers;


import org.recipe.models.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class LoginController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String init(Model model) {
        model.addAttribute("msg", "Please enter your login details");
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submit(Model model, @ModelAttribute("login") Login login) {
        if (login != null && login.getUserName() != null & login.getPassword() != null) {
            model.addAttribute("msg", "Welcome" + login.getUserName());
            return "index";
        } else {
            model.addAttribute("error", "Invalid Details");
            return "login";
        }
    }
}
