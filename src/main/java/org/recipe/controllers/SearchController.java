package org.recipe.controllers;


import org.recipe.models.Recipe;
import org.recipe.models.RecipeFieldType;
import org.recipe.models.data.RecipeDao;
import org.recipe.models.forms.SearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;


@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private RecipeDao recipeDao;

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute(new SearchForm());
        return "search";
    }

    @RequestMapping(value = "results")
    public String search(Model model,
                         @ModelAttribute SearchForm searchForm) {

        ArrayList<Recipe> recipes = new ArrayList<>();
        Iterable<Recipe> recipeList = recipeDao.findAll();

        if (searchForm.getSearchField().equals(RecipeFieldType.ALL)) {
            for (Recipe recipe : recipeList) {
                if ((recipe.getName() + recipe.getIngredient()).toLowerCase().contains(searchForm.getKeyword())) {
                    recipes.add(recipe);
                }
            }
        } else if (searchForm.getSearchField().equals(RecipeFieldType.INGREDIENT)) {
            for (Recipe recipe : recipeList) {
                if (recipe.getIngredient().toLowerCase().contains(searchForm.getKeyword())) {
                    recipes.add(recipe);
                }
            }
        } else if (searchForm.getSearchField().equals(RecipeFieldType.NAME)) {
            for (Recipe recipe : recipeList) {
                if (recipe.getName().toLowerCase().contains(searchForm.getKeyword())) {
                    recipes.add(recipe);
                }
            }
        }
        model.addAttribute("recipes", recipes);
        return "search";
    }

}
