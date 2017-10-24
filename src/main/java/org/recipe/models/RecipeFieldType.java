package org.recipe.models;

public enum RecipeFieldType {

    ALL ("All"),
    NAME ("Name"),
    INGREDIENT ("Ingredient"),
    USERNAME ("Username");

    private final String name;

    RecipeFieldType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
