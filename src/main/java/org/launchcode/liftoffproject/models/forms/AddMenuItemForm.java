package org.launchcode.liftoffproject.models.forms;

import org.launchcode.liftoffproject.models.Food;
import org.launchcode.liftoffproject.models.Menu;

import javax.validation.constraints.NotNull;

public class AddMenuItemForm {
    private Menu menu;

    private Iterable<Food> foods;

    @NotNull
    private int menuId;

    @NotNull
    private int foodId;

    public AddMenuItemForm() { }

    public AddMenuItemForm(Menu menu, Iterable<Food> foods) {
        this.menu = menu;
        this.foods = foods;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Iterable<Food> getFoods() {
        return foods;
    }

    public void setFoods(Iterable<Food> foods) {
        this.foods = foods;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }
}
