package com.company.restaurant.application;

import com.company.util.MenuItem;

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
