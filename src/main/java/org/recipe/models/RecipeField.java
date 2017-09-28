package org.recipe.models;

public class RecipeField {

    private String value;
    private int id;
    private static int nextId = 1;

    public RecipeField() {
        id = nextId;
        nextId++;
    }

    public RecipeField(String aValue) {
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

        RecipeField recipeField = (RecipeField) o;

        return id == recipeField.getId();
    }

    @Override
    public int hashCode() {
        return id;
    }

}
