package com.company.restaurant.application;

import com.company.util.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseFind extends DatabaseMenuItem implements MenuItem {
    public MenuItemCourseFind(String itemText) {
        super(itemText);
    }

    @Override
    public void menuAction() {
        findCouseByName();
    }

    private void findCouseByName() {

    }
}
