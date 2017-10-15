package org.recipe.controllers;

import org.recipe.models.User;
import org.recipe.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.validation.Valid;


@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(Model model){
        User user = new User();
        model.addAttribute("title", "Add User");
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User user, Errors errors, String verify){
        model.addAttribute("verify", verify);

        if (!errors.hasErrors() && !verify.isEmpty() && user.getPassword().equals(verify)){
            model.addAttribute("title", "Welcome, " + user.getUsername());
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            userDao.save(user);
            return "index";
        }else{
            String verifyError = "";
            if(verify.isEmpty() || !user.getPassword().equals(verify)){
                verifyError = "Please enter a matching Password";
            }
            model.addAttribute(user);
            model.addAttribute("title", "Add User");
            model.addAttribute("verifyError", verifyError);
            return "register";
        }
    }
}