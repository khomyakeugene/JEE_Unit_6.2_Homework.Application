package com.company.restaurant.application.menu;

/**
 * Created by Yevhen on 25.05.2016.
 */
public abstract class DatabaseMenuItem<T> extends DatabaseFunctionality<T> implements MenuItem {
    private String itemText;

    public DatabaseMenuItem(String itemText) {
        this.itemText = itemText;
    }

    @Override
    public String getItemText() {
        return itemText;
    }
}
