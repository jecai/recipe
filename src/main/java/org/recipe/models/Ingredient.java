//package org.recipe.models;
//
//public class Ingredient extends RecipeField {
//
//    public Ingredient(String value) {
//        super(value);
//    }
//}


package org.recipe.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3)
    private String ingredient;

    public Ingredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public Ingredient() {
    }

    public int getId() {
        return id;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

}
