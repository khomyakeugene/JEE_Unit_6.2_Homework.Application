package com.company.restaurant.application.menu;

import com.company.util.Util;

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

    protected void errorMessage(String message) {
        Util.printMessage(message);
    }
}
