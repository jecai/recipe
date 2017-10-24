package org.recipe.controllers;

import org.recipe.models.Ingredient;
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

    //display id for ingredients
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int ingredientId) {

        //get the Ingredient with the given ID and pass it into the view
        model.addAttribute("ingredient", ingredientDao.findOne(ingredientId));
        return "ingredient-detail";
    }

    //adding the Ingredient
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Ingredient");
        model.addAttribute("unit", "Add Unit Measurement");
        return "new-ingredient";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Ingredient ingredient, Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Ingredient");
            model.addAttribute("unit", "Add Unit Measurement");
            model.addAttribute(ingredient);
            return "new-ingredient";
        }

        ingredientDao.save(ingredient);
        return "redirect:/ingredient/?id=" + Integer.toString(ingredient.getIngredientId());

    }

    //edit the ingredient
    @RequestMapping(value = "edit/{ingredientId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int ingredientID) {
        Ingredient ingredient = ingredientDao.findOne(ingredientID);
        model.addAttribute("ingredient", ingredient);
        model.addAttribute("title", "Edit Ingredient: " +
                ingredient.getIngredientName());
        model.addAttribute("unit", "Edit Unit Measurement:" +
                ingredient.getIngredientUnit());
        model.addAttribute("ingredientID", ingredientID);
        return "edit";
    }

    @RequestMapping(value = "editing", method = RequestMethod.POST)
    public String processEditForm(Model model, int ingredientID,
                                  @ModelAttribute @Valid Ingredient newIngredient,
                                  Errors errors) {

        Ingredient ingredient = ingredientDao.findOne(ingredientID);

        if (errors.hasErrors()) {
            model.addAttribute("ingredient", newIngredient);
            model.addAttribute("title", "Edit Ingredient: " +
                    ingredient.getIngredientName());
            model.addAttribute("unit", "Edit Unit Measurement: " +
                    ingredient.getIngredientUnit());
            model.addAttribute("ingredientID", ingredientID);
            return "edit";
        }

        ingredient.setIngredientName(newIngredient.getIngredientName());
        ingredient.setIngredientUnit(newIngredient.getIngredientUnit());
        ingredientDao.save(ingredient);
        return "redirect:/ingredient/?id=" + Integer.toString(ingredient.getIngredientId());
    }
}
