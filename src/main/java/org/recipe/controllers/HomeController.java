package org.recipe.controllers;

import org.recipe.models.data.RecipeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class HomeController extends AbstractController {

    @Autowired
    private RecipeDao recipeDao;

    @RequestMapping(value = "")
    public String index(Model model, HttpServletRequest request) {

        model.addAttribute("title", "All Recipes");
        model.addAttribute("recipes", recipeDao.findAll());
        model.addAttribute("sessionOn", isSessionActive(request.getSession()));

        return "index";
    }

}
