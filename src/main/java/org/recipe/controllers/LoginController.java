package org.recipe.controllers;

import org.recipe.models.RecipeFieldType;
import org.recipe.models.User;
import org.recipe.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("username")
public class LoginController {

    @Autowired
    private UserDao userDao;



    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String showLogin() {
        return "login";
    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String processLogin(Model model, @RequestParam String username, @RequestParam String password) {
        Iterable<User> userList = userDao.findAll();
        boolean usernameLogin = false;
        boolean passwordLogin = false;

        for (User user : userList) {
            if (username.equals(user.getUsername())) {
                if (password.equals(user.getPassword())) {
                    usernameLogin = true;
                    passwordLogin = true;
                } else {
                    usernameLogin = true;
                    passwordLogin = false;
                }
            }
        }
        if (usernameLogin) {
            if (!passwordLogin) {
                model.addAttribute("passwordError", "Wrong password! Please try again!");
                return "login";
            }
            model.addAttribute("username", username);
            RecipeFieldType[] fields = RecipeFieldType.values();
            model.addAttribute("fields", fields);
            return "list";
        }
        model.addAttribute("usernameError", "Invalid username! Please try again!");
        return "login";
    }

    @RequestMapping(value = "logout")
    public String logout() {
        return "redirect:/login";
    }

}
