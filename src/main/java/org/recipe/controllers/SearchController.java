package org.recipe.controllers;

import org.recipe.models.Recipe;
import org.recipe.models.RecipeFieldType;
import org.recipe.models.data.RecipeData;
import org.recipe.models.forms.SearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    private RecipeData recipeData = RecipeData.getInstance();

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute(new SearchForm());
        return "search";
    }

    @RequestMapping(value = "results")
    public String search(Model model,
                         @ModelAttribute SearchForm searchForm) {

        ArrayList<Recipe> recipes;

        if (searchForm.getSearchField().equals(RecipeFieldType.ALL)) {
            recipes = recipeData.findByValue(searchForm.getKeyword());
        } else {
            recipes = recipeData.findByColumnAndValue(searchForm.getSearchField(), searchForm.getKeyword());
        }

        model.addAttribute("recipes", recipes);

        return "search";
    }

}
