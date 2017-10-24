package org.recipe.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private int ingredientId;
    private String ingredientName;
    private String ingredientUnit;


    //Constructors
    public Ingredient() {}
    public Ingredient(String ingredientName, String ingredientUnit, int ingredientId) {
        this.ingredientName = ingredientName;
        this.ingredientUnit = ingredientUnit;
        this.ingredientId = ingredientId;
    }

    //Getters/Setter
    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientUnit() {
        return ingredientUnit;
    }

    public void setIngredientUnit(String ingredientUnit) {
        this.ingredientUnit = ingredientUnit;
    }

    @Override
    public String toString() {
        return "ingredient information:\n" + "ingredient name: " + ingredientName +
                "\ningredient unit: " + ingredientUnit + "\ningredient id: " + ingredientId;
    }

}
