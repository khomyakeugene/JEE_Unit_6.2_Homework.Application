package com.company.restaurant.application.menu;

import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class MenuItemWarehouseAdd extends SafeMenuItem implements MenuItem {
    public MenuItemWarehouseAdd(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {

    }
}
