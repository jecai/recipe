//package org.recipe.models.data;
//
//import org.recipe.models.*;
//
//import java.util.ArrayList;
//
//
//public class RecipeData {
//
//    private ArrayList<Recipe> recipes = new ArrayList<>();
//    private static RecipeData instance;
//
//    private RecipeFieldData<Ingredient> ingredients = new RecipeFieldData<>();
//    private RecipeFieldData<Serving> servings = new RecipeFieldData<>();
//    private RecipeFieldData<Calorie> calories = new RecipeFieldData<>();
//    private RecipeFieldData<ImageUrl> imageUrls = new RecipeFieldData<>();
//
//
//    private RecipeData() {
//        RecipeDataImporter.loadData(this);
//    }
//
//
//    public static RecipeData getInstance() {
//        if (instance == null) {
//            instance = new RecipeData();
//        }
//        return instance;
//    }
//
//    public Recipe findById(int id) {
//        for (Recipe recipe : recipes) {
//            if (recipe.getId() == id)
//                return recipe;
//        }
//
//        return null;
//    }
//
//    public ArrayList<Recipe> findAll() {
//        return recipes;
//    }
//
//
//    public ArrayList<Recipe> findByColumnAndValue(RecipeFieldType column, String value) {
//
//        ArrayList<Recipe> matchingRecipes = new ArrayList<>();
//
//        for (Recipe recipe : recipes) {
//            if (getFieldByType(recipe, column).contains(value))
//                matchingRecipes.add(recipe);
//        }
//
//        return matchingRecipes;
//    }
//
//
//    public ArrayList<Recipe> findByValue(String value) {
//
//        ArrayList<Recipe> matchingRecipes = new ArrayList<>();
//
//        for (Recipe recipe : recipes) {
//
//            if (recipe.getName().toLowerCase().contains(value)) {
//                matchingRecipes.add(recipe);
//                continue;
//            }
//
//            for (RecipeFieldType column : RecipeFieldType.values()) {
//                if (column != RecipeFieldType.ALL && getFieldByType(recipe, column).contains(value)) {
//                    matchingRecipes.add(recipe);
//                    break;
//                }
//            }
//        }
//
//        return matchingRecipes;
//    }
//
//
//    public void add(Recipe recipe) {
//        recipes.add(recipe);
//    }
//
//
//    private static RecipeField getFieldByType(Recipe recipe, RecipeFieldType type) {
//        switch(type) {
//            case INGREDIENT:
//                return recipe.getIngredient();
//            case SERVING:
//                return recipe.getServing();
//            case CALORIE:
//                return recipe.getCalorie();
//            case IMAGEURL:
//                return recipe.getImageUrl();
//        }
//
//        throw new IllegalArgumentException("Cannot get field of type " + type);
//    }
//
//    public RecipeFieldData<Ingredient> getIngredients() { return ingredients; }
//
//    public RecipeFieldData<Serving> getServings() {
//        return servings;
//    }
//
//    public RecipeFieldData<Calorie> getCalores() {
//        return calories;
//    }
//
//    public RecipeFieldData<ImageUrl> getImageUrl() {
//        return imageUrls;
//    }
//
//}
