package com.company.restaurant.application.menu.service;

import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public abstract class SimpleMenuItem implements MenuItem {
    private String itemText;

    public SimpleMenuItem(String itemText) {
        this.itemText = itemText;
    }

    @Override
    public String getItemText() {
        return itemText;
    }
}
