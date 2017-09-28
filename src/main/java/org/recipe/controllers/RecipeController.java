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
        model.addAttribute("job", recipeData.findById(id));
        return "job-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new RecipeForm());
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid RecipeForm recipeForm, Errors errors) {

        // TODO #6 - Validate the RecipeForm model, and if valid, create a
        // new Recipe and add it to the recipeData data store. Then
        // redirect to the job detail view for the new Recipe.

        if (errors.hasErrors()) {
            model.addAttribute(recipeForm);
            return "new-job";
        }

        Recipe newRecipe = new Recipe(recipeForm.getName(),
                recipeData.getIngredients().findById(recipeForm.getIngredientId()),
                recipeData.getServings().findById(recipeForm.getServingId()),
                recipeData.getCalores().findById(recipeForm.getCalorieId()),
                recipeData.getImageUrl().findById(recipeForm.getImageUrlId()));
        recipeData.add(newRecipe);
        return "redirect:/job/?id=" + Integer.toString(newRecipe.getId());

    }
}
