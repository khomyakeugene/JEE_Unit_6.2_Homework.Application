package com.company.restaurant.application.menu;

import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SimpleMenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmptyAction extends SimpleMenuItem implements MenuItem {
    public MenuItemEmptyAction(String itemText) {
        super(itemText);
    }

    @Override
    public void menuAction() {

    }
}
