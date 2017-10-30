package org.recipe.models;

import javax.persistence.*;
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
    @Size(min=3, max=30)
    private String name;

    @NotNull
    @Size(min=3)
    private String ingredient;

    @NotNull
    @Min(1)
    private int serving;

    @NotNull
    @Min(0)
    private int calorie;

    @NotNull
    @Size(min=1)
    private String imageUrl;

    @ManyToMany
    private List<Menu> menus;

    @ManyToOne
    private User author;

    @ManyToMany(mappedBy = "favorites")
    private List<User> favoritedBy;

    public Recipe(String name, String ingredient, int serving, int calorie, String imageUrl) {
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

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public int getServing() {
        return serving;
    }

    public void setServing(int serving) {
        this.serving = serving;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<User> getFavoritedBy() {
        return favoritedBy;
    }

    public void setFavoritedBy(List<User> favoritedBy) {
        this.favoritedBy = favoritedBy;
    }
}
