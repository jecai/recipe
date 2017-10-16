package org.recipe.controllers;

import org.recipe.models.RecipeFieldType;
import org.recipe.models.User;
import org.recipe.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@SessionAttributes("username")
public class RegistrationController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register(Model model){
        User user = new User();
        model.addAttribute("title", "Register User");
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid User newUser, @RequestParam String username, Errors errors, String verify){
        model.addAttribute("verify", verify);

        Iterable<User> userList = userDao.findAll();
        boolean usernameExist = false;
        boolean passwordExist = false;
        for (User user: userList) {
            if (newUser.getUsername().equals(user.getUsername())) {
                if (newUser.getPassword().equals(user.getPassword())) {
                    usernameExist = true;
                    passwordExist = true;
                } else {
                    usernameExist = true;
                    passwordExist = false;
                }
            }
        }
        if (!errors.hasErrors() && !verify.isEmpty() && newUser.getPassword().equals(verify)) {
            if (!usernameExist) {
                if (!passwordExist) {
                    model.addAttribute("title", "Welcome, " + newUser.getUsername());
                    model.addAttribute("username", username);
                    userDao.save(newUser);
                    RecipeFieldType[] fields = RecipeFieldType.values();
                    model.addAttribute("fields", fields);
                    return "list";
                }
                model.addAttribute("title", "Welcome, " + newUser.getUsername());
                model.addAttribute("username", username);
                userDao.save(newUser);
                RecipeFieldType[] fields = RecipeFieldType.values();
                model.addAttribute("fields", fields);
                return "list";
            } else {
                model.addAttribute("existingUsername", "Username already exists");
                return "register";
            }
        } else {
            String verifyError = "";
            if (verify.isEmpty() || !newUser.getPassword().equals(verify)) {
                verifyError = "Please enter a matching Password";
            }
            model.addAttribute(newUser);
            model.addAttribute("title", "Add User");
            model.addAttribute("verifyError", verifyError);
            return "register";
        }
    }
}