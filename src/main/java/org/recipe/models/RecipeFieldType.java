package org.recipe.models;

public enum RecipeFieldType {

    ALL ("All"),
    NAME ("Name"),
    INGREDIENT ("Ingredient");

    private final String name;

    RecipeFieldType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
