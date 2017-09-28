package org.recipe.models;

public class Recipe {

    private int id;
    private static int nextId = 1;

    private String name;
    private Ingredient ingredient;
    private Serving serving;
    private Calorie calorie;
    private ImageUrl imageUrl;

    public Recipe() {
        id = nextId;
        nextId++;
    }

    public Recipe(String aName, Ingredient aIngredient, Serving aServing,
                  Calorie aCalorie, ImageUrl aImageUrl) {

        this();

        name = aName;
        ingredient = aIngredient;
        serving = aServing;
        calorie = aCalorie;
        imageUrl = aImageUrl;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Serving getServing() {
        return serving;
    }

    public void setServing(Serving serving) {
        this.serving = serving;
    }

    public Calorie getCalorie() {
        return calorie;
    }

    public void setCalorie(Calorie calorie) {
        this.calorie = calorie;
    }

    public ImageUrl getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(ImageUrl imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Recipe recipe = (Recipe) o;

        return id == recipe.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
