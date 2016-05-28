package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.service.ExtendedDatabaseService;
import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public abstract class ExtendedDatabaseMenuItem<T> extends ExtendedDatabaseService<T> implements MenuItem {
    private String itemText;

    public ExtendedDatabaseMenuItem(String itemText) {
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
            e.printStackTrace();
        }
    }
}
