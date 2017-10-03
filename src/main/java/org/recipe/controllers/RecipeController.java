package org.recipe.controllers;

import org.recipe.models.Recipe;
import org.recipe.models.data.RecipeData;
import org.recipe.models.forms.RecipeForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "recipe")
public class RecipeController {

    private RecipeData recipeData = RecipeData.getInstance();

    // The detail display for a given Recipe at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {

        //get the Recipe with the given ID and pass it into the view
        model.addAttribute("recipe", recipeData.findById(id));
        return "recipe-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new Recipe());
        return "new-recipe";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid Recipe recipe, Errors errors) {

        // TODO #6 - Validate the RecipeForm model, and if valid, create a
        // new Recipe and add it to the recipeData data store. Then
        // redirect to the job detail view for the new Recipe.

        if (errors.hasErrors()) {
            model.addAttribute(recipe);
            return "new-recipe";
        }

        recipeData.add(recipe);
        return "redirect:/recipe/?id=" + Integer.toString(recipe.getId());

    }
}
