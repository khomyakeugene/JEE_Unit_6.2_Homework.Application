package com.company.restaurant.application;

import com.company.util.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeDelete extends DatabaseMenuItem implements MenuItem {
    public MenuItemEmployeeDelete(String itemText) {
        super(itemText);
    }

    @Override
    public void menuAction() {
        deleteEmployee();
    }

    private void deleteEmployee() {

    }
}
