package com.company.restaurant.application;

import com.company.util.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeFind extends DatabaseMenuItem implements MenuItem {
    public MenuItemEmployeeFind(String itemText) {
        super(itemText);
    }

    @Override
    public void menuAction() {
        findEmployee();
    }

    private void findEmployee() {

    }
}
