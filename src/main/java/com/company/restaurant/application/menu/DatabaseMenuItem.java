package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.ExtendedDatabaseService;

/**
 * Created by Yevhen on 25.05.2016.
 */
public abstract class DatabaseMenuItem<T> extends ExtendedDatabaseService<T> implements MenuItem {
    private String itemText;

    public DatabaseMenuItem(String itemText) {
        this.itemText = itemText;
    }

    @Override
    public String getItemText() {
        return itemText;
    }

    protected void executeAction() {
        processObject();
    }

    @Override
    public final void menuAction() {
        try {
            executeAction();
        } catch (Exception e) {
            errorMessage(e.getMessage());
        }
    }
}
