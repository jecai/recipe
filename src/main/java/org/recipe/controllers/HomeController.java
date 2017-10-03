package org.recipe.controllers;

import org.recipe.models.Recipe;
import org.recipe.models.data.RecipeData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {
    private RecipeData recipeData = RecipeData.getInstance();

    @RequestMapping(value = "")
    public String index(Model model) {
        ArrayList<Recipe> recipes = recipeData.findAll();

        model.addAttribute("title", "All Recipes");
        model.addAttribute("recipes", recipes);

        return "index";
    }

}
