package org.recipe.models.forms;

import org.recipe.models.Recipe;
import org.recipe.models.Menu;

import javax.validation.constraints.NotNull;

public class MenuForm {
    private Menu menu;
    private Iterable<Recipe> recipes;

    @NotNull
    private int menuId;

    @NotNull
    private int recipeId;

    public MenuForm(Iterable<Recipe> recipes, Menu menu){
        this.menu = menu;
        this.recipes = recipes;
    }

    public MenuForm() {}

    public Menu getMenu() { return menu; }
    public void setMenu(Menu menu) { this.menu = menu; }

    public Iterable<Recipe> getRecipes() { return recipes; }
    public void setRecipes(Iterable<Recipe> recipes) {
        this.recipes = recipes;
    }

    public int getMenuId() { return menuId; }
    public void setMenuId(int menuId) { this.menuId = menuId; }

    public int getRecipeId() { return recipeId; }
    public void setRecipeId(int recipeId) { this.recipeId = recipeId; }

}
