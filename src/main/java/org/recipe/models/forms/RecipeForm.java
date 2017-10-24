//package org.recipe.models.forms;
//
//
//import org.recipe.models.Ingredient;
//import org.recipe.models.Recipe;
//
//import javax.validation.constraints.NotNull;
//import java.util.List;
//
//public class RecipeForm {
//
//    private Recipe recipe;
//    private Iterable<Ingredient> ingredients;
//
//    @NotNull
//    private int ingredientId;
//
//    @NotNull
//    private String ingredientName;
//
//    @NotNull
//    private String ingredientUnit;
//
//
//    private List<Ingredient> ingredients;
//
//
//    public RecipeForm() {
//
//        RecipeData recipeData = RecipeData.getInstance();
//
//        /*
//            TODO #4 - populate the other ArrayList collections needed in the view
//        */
//
//        ingredients = recipeData.getIngredients().findAll();
//        servings = recipeData.getServings().findAll();
//        calories = recipeData.getCalores().findAll();
//        imageUrls = recipeData.getImageUrl().findAll();
//
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public ArrayList<Ingredient> getIngredients() {
//        return ingredients;
//    }
//
//    public void setIngredients(ArrayList<Ingredient> ingredients) {
//        this.ingredients = ingredients;
//    }
//
//    public ArrayList<Serving> getServings() {
//        return servings;
//    }
//
//    public void setServings(ArrayList<Serving> servings) {
//        this.servings = servings;
//    }
//
//    public ArrayList<Calorie> getCalories() {
//        return calories;
//    }
//
//    public void setCalories(ArrayList<Calorie> calories) {
//        this.calories = calories;
//    }
//
//    public ArrayList<ImageUrl> getImageUrls() {
//        return imageUrls;
//    }
//
//    public void setImageUrls(ArrayList<ImageUrl> imageUrls) {
//        this.imageUrls = imageUrls;
//    }
//
//    public int getIngredientId() {
//        return ingredientId;
//    }
//
//    public void setIngredientId(int ingredientId) {
//        this.ingredientId = ingredientId;
//    }
//
//    public int getServingId() {
//        return servingId;
//    }
//
//    public void setServingId(int servingId) {
//        this.servingId = servingId;
//    }
//
//    public int getCalorieId() {
//        return calorieId;
//    }
//
//    public void setCalorieId(int calorieId) {
//        this.calorieId = calorieId;
//    }
//
//    public int getImageUrlId() {
//        return imageUrlId;
//    }
//
//    public void setImageUrlId(int imageUrlId) {
//        this.imageUrlId = imageUrlId;
//    }
//
//}
