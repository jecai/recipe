package org.recipe.controllers;

import org.recipe.models.Recipe;
import org.recipe.models.RecipeField;
import org.recipe.models.RecipeFieldType;
import org.recipe.models.data.RecipeData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "list")
public class ListController {

    private RecipeData recipeData = RecipeData.getInstance();

    @RequestMapping(value = "")
    public String list(Model model) {
        RecipeFieldType[] fields = RecipeFieldType.values();
        model.addAttribute("fields", fields);
        return "list";
    }

    @RequestMapping(value = "values")
    public String listColumnValues(Model model, @RequestParam RecipeFieldType column) {

        if (column.equals(RecipeFieldType.ALL)) {
            return "redirect:/list/all";
        }


        ArrayList<? extends RecipeField> items;

        switch(column) {
            case INGREDIENT:
                items = recipeData.getIngredients().findAll();
                break;
            case SERVING:
                items = recipeData.getServings().findAll();
                break;
            case CALORIE:
                items = recipeData.getCalores().findAll();
                break;
            case IMAGEURL:
            default:
                items = recipeData.getImageUrl().findAll();
        }

        model.addAttribute("title", "All " + column.getName() + " Values");
        model.addAttribute("column", column);
        model.addAttribute("items", items);

        return "list-column";
    }

    @RequestMapping(value = "recipes")
    public String listJobsByColumnAndValue(Model model,
                                           @RequestParam RecipeFieldType column, @RequestParam String name) {

        ArrayList<Recipe> recipes = recipeData.findByColumnAndValue(column, name);

        model.addAttribute("title", "Recipes with " + column.getName() + ": " + name);
        model.addAttribute("recipes", recipes);

        return "list-recipes";
    }

    @RequestMapping(value = "all")
    public String listAllJobs(Model model) {

        ArrayList<Recipe> recipes = recipeData.findAll();

        model.addAttribute("title", "All Recipes");
        model.addAttribute("recipes", recipes);

        return "list-recipes";
    }
}
