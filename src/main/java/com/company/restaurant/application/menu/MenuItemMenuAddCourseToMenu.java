package com.company.restaurant.application.menu;

import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuAddCourseToMenu extends MenuItemMenuCourse implements MenuItem {

    public MenuItemMenuAddCourseToMenu(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        menuCourseCollector.addItemsToObject();
    }
}

