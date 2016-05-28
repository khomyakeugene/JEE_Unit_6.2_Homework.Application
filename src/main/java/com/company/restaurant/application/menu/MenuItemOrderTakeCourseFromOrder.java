package com.company.restaurant.application.menu;

import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderTakeCourseFromOrder extends DatabaseMenuItem implements MenuItem {
    public MenuItemOrderTakeCourseFromOrder(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {

    }
}
