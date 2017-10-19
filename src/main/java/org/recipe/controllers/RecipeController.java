package org.recipe.controllers;

import org.recipe.models.Recipe;
import org.recipe.models.data.RecipeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "recipe")
public class RecipeController extends AbstractController {

    @Autowired
    private RecipeDao recipeDao;

    // The detail display for a given Recipe at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {

        //get the Recipe with the given ID and pass it into the view
        model.addAttribute("recipe", recipeDao.findOne(id));
        return "recipe-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model, HttpServletRequest request) {
        model.addAttribute("title", "Add Recipe");
        model.addAttribute(new Recipe());
        model.addAttribute("sessionOn", isSessionActive(request.getSession()));
        return "new-recipe";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Recipe recipe, Errors errors, HttpServletRequest request) {

        // TODO #6 - Validate the RecipeForm model, and if valid, create a
        // new Recipe and add it to the recipeData data store. Then
        // redirect to the job detail view for the new Recipe.

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Recipe");
            model.addAttribute(recipe);
            return "new-recipe";
        }
        model.addAttribute("sessionOn", isSessionActive(request.getSession()));
        recipe.setAuthor(getUserFromSession(request.getSession()));
        recipeDao.save(recipe);
        return "redirect:/recipe/?id=" + Integer.toString(recipe.getId());

    }

    @RequestMapping(value = "edit/{recipeId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int recipeId, HttpServletRequest request) {
        Recipe recipe = recipeDao.findOne(recipeId);
        model.addAttribute("recipe", recipe);
        model.addAttribute("title", "Edit Recipe: " +
                recipe.getName());
        model.addAttribute("recipeId", recipeId);
        model.addAttribute("sessionOn", isSessionActive(request.getSession()));
        return "edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String processEditForm(Model model, int recipeId,
                                  @ModelAttribute @Valid Recipe newRecipe,
                                  Errors errors, HttpServletRequest request) {

        Recipe recipe = recipeDao.findOne(recipeId);

        if (errors.hasErrors()) {
            model.addAttribute("recipe", newRecipe);
            model.addAttribute("title", "Edit Recipe: " +
                    recipe.getName());
            model.addAttribute("recipeId", recipeId);
            return "edit";
        }

        recipe.setName(newRecipe.getName());
        recipe.setIngredient(newRecipe.getIngredient());
        recipe.setServing(newRecipe.getServing());
        recipe.setCalorie(newRecipe.getCalorie());
        recipe.setImageUrl(newRecipe.getImageUrl());
        recipeDao.save(recipe);
        model.addAttribute("sessionOn", isSessionActive(request.getSession()));
        return "redirect:/recipe/?id=" + Integer.toString(recipe.getId());
    }
}
