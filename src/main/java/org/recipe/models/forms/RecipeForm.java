package org.recipe.models.forms;

import org.recipe.models.Calorie;
import org.recipe.models.ImageUrl;
import org.recipe.models.Ingredient;
import org.recipe.models.Serving;
import org.recipe.models.data.RecipeData;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

public class RecipeForm {

    @NotNull
    @Size(min=1, message = "Name may not be empty")
    private String name;

    @NotNull
    private int ingredientId;

    @NotNull
    private int servingId;

    @NotNull
    private int calorieId;

    @NotNull
    private int imageUrlId;

    private ArrayList<Ingredient> ingredients;
    private ArrayList<Serving> servings;
    private ArrayList<Calorie> calories;
    private ArrayList<ImageUrl> imageUrls;

    public RecipeForm() {

        RecipeData recipeData = RecipeData.getInstance();

        /*
            TODO #4 - populate the other ArrayList collections needed in the view
        */

        ingredients = recipeData.getIngredients().findAll();
        servings = recipeData.getServings().findAll();
        calories = recipeData.getCalores().findAll();
        imageUrls = recipeData.getImageUrl().findAll();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<Serving> getServings() {
        return servings;
    }

    public void setServings(ArrayList<Serving> servings) {
        this.servings = servings;
    }

    public ArrayList<Calorie> getCalories() {
        return calories;
    }

    public void setCalories(ArrayList<Calorie> calories) {
        this.calories = calories;
    }

    public ArrayList<ImageUrl> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(ArrayList<ImageUrl> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getServingId() {
        return servingId;
    }

    public void setServingId(int servingId) {
        this.servingId = servingId;
    }

    public int getCalorieId() {
        return calorieId;
    }

    public void setCalorieId(int calorieId) {
        this.calorieId = calorieId;
    }

    public int getImageUrlId() {
        return imageUrlId;
    }

    public void setImageUrlId(int imageUrlId) {
        this.imageUrlId = imageUrlId;
    }

}
