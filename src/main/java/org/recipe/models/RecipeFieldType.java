package org.recipe.models;

public enum RecipeFieldType {

    INGREDIENT ("Ingredient"),
    SERVING ("Serving"),
    CALORIE ("Calorie"),
    IMAGEURL ("Image Url"),
    ALL ("All");

    private final String name;

    RecipeFieldType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
