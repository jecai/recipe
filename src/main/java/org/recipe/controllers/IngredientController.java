package org.recipe.controllers;

import org.recipe.models.Ingredient;
import org.recipe.models.Recipe;
import org.recipe.models.data.IngredientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "ingredient")
public class IngredientController {

    @Autowired
    private IngredientDao ingredientDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {

        //get the Recipe with the given ID and pass it into the view
        model.addAttribute("recipe", ingredientDao.findOne(id));
        return "recipe-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Ingredient");
        model.addAttribute(new Ingredient());
        return "new-recipe";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Recipe recipe, Errors errors) {

        // TODO #6 - Validate the RecipeForm model, and if valid, create a
        // new Recipe and add it to the recipeData data store. Then
        // redirect to the job detail view for the new Recipe.

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Recipe");
            model.addAttribute(recipe);
            return "new-recipe";
        }

        ingredientDao.save(ingredient);
        return "redirect:/ingredient/?id=" + Integer.toString(ingredientDao.getId());

    }

    @RequestMapping(value = "edit/{ingredientID}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int ingredientID) {
        Ingredient ingredient = ingredientDao.findOne(ingredientID);
        model.addAttribute("ingredient", ingredient);
        model.addAttribute("title", "Edit Ingredient: " +
                ingredient.getIngredientName());
        model.addAttribute("ingredientID", ingredientID);
        return "edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(Model model, int recipeId,
                                  @ModelAttribute @Valid Recipe newRecipe,
                                  Errors errors) {

        Recipe recipe = ingredientDao.findOne(recipeId);

        if (errors.hasErrors()) {
            model.addAttribute("ingredient", newIngredient);
            model.addAttribute("title", "Edit Ingredient: " +
                    ingredient.get());
            model.addAttribute("ingredientID", ingredientID);
            return "edit";
        }

        recipe.setName(newIngredient.getName());
        recipe.setIngredient(newRecipe.getIngredient());
        recipe.setServing(newRecipe.getServing());
        recipe.setCalorie(newRecipe.getCalorie());
        recipe.setImageUrl(newRecipe.getImageUrl());
        ingredientDao.save(ingredient);
        return "redirect:/recipe/?id=" + Integer.toString(recipe.getId());
    }
}
