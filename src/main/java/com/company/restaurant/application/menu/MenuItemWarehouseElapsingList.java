package com.company.restaurant.application.menu;

import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class MenuItemWarehouseElapsingList extends SafeMenuItem implements MenuItem {
    public MenuItemWarehouseElapsingList(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {

    }
}
