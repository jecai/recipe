package org.recipe.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, max=150, message = "Please enter the recipe name")
    private String name;

    @NotNull
    @Size(min=3)
    @ManyToMany
    private List<Ingredient>ingredient;

    @NotNull(message = "Please enter the number of servings")
    @Min(1)
    private Integer serving;

    @NotNull(message = "Please enter the number of calories")
    @Min(0)
    private Integer calorie;

    @NotNull
    @Size(min=1)
    private String imageUrl;

    public Recipe(String name, List<Ingredient> ingredient, Integer serving, Integer calorie, String imageUrl) {
        this.name = name;
        this.ingredient = ingredient;
        this.serving = serving;
        this.calorie = calorie;
        this.imageUrl = imageUrl;
    }

    public Recipe() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredient() {
        return ingredient;
    }

    //    public String getIngredient() {
//        return ingredient;
//    }
//
//    public void setIngredient(String ingredient) {
//        this.ingredient = ingredient;
//    }

    public Integer getServing() {
        return serving;
    }

    public void setServing(Integer serving) {
        this.serving = serving;
    }

    public Integer getCalorie() {
        return calorie;
    }

    public void setCalorie(Integer calorie) {
        this.calorie = calorie;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setIngredient(List<Ingredient> ingredient) {
        this.ingredient = ingredient;
    }
}
