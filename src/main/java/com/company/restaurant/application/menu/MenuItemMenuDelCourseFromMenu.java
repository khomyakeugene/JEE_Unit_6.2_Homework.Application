package com.company.restaurant.application.menu;

import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuDelCourseFromMenu extends DatabaseMenuItem implements MenuItem {
    public MenuItemMenuDelCourseFromMenu(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {

    }
}
