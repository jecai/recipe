package org.recipe.models;

public class IngredientField {

    private String value;
    private int id;
    private static int nextId = 1;

    public IngredientField() {
        id = nextId;
        nextId++;
    }

    public IngredientField(String aValue) {
        this();
        value = aValue;
    }

    public boolean contains(String value) {
        return this.value.toLowerCase().contains(value.toLowerCase());
    }

    public String getValue() {
        return value;
    }

    public void setValue(String aValue) {
        value = aValue;
    }

    public String toString() {
        return value;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        org.recipe.models.IngredientField ingredientField = (org.recipe.models.IngredientField) o;

        return id == ingredientField.getId();
    }

    @Override
    public int hashCode() {
        return id;
    }
}
