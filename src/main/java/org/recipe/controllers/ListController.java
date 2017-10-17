package org.recipe.controllers;

import org.recipe.models.Recipe;
import org.recipe.models.RecipeField;
import org.recipe.models.RecipeFieldType;
import org.recipe.models.data.RecipeDao;
import org.recipe.models.forms.SearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "list")
public class ListController extends AbstractController {

    @Autowired
    private RecipeDao recipeDao;

    @RequestMapping(value = "")
    public String list(Model model) {
        RecipeFieldType[] fields = RecipeFieldType.values();
        model.addAttribute("fields", fields);
        return "list";
    }

//    @RequestMapping(value = "values")
//    public String listColumnValues(Model model, @ModelAttribute SearchForm searchForm, @RequestParam RecipeFieldType column) {
//
//        if (column.equals(RecipeFieldType.ALL)) {
//            return "redirect:/list/all";
//        }
//
//
//        ArrayList<? extends RecipeField> items;
//        Iterable<Recipe> recipeList = recipeDao.findAll();
//
//        switch(column) {
//            case INGREDIENT:
//                items = recipeList.equals()
//        }
//
//
//        model.addAttribute("title", "All " + column.getName() + " Values");
//        model.addAttribute("column", column);
//        model.addAttribute("items", items);
//
//        return "list-column";
//    }
//
//    @RequestMapping(value = "recipes")
//    public String listJobsByColumnAndValue(Model model,
//                                           @RequestParam RecipeFieldType column, @RequestParam String name) {
//
//        ArrayList<Recipe> recipes = recipeData.findByColumnAndValue(column, name);
//
//        model.addAttribute("title", "Recipes with " + column.getName() + ": " + name);
//        model.addAttribute("recipes", recipes);
//
//        return "list-recipes";
//    }

    @RequestMapping(value = "all")
    public String listAllJobs(Model model) {

        model.addAttribute("title", "All Recipes");
        model.addAttribute("recipes", recipeDao.findAll());

        return "list-recipes";
    }

}
