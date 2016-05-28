package com.company.restaurant.application.menu;

import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderAddCourseToOrder extends DatabaseMenuItem implements MenuItem {
    public MenuItemOrderAddCourseToOrder(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {

    }
}
