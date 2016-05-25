package com.company.restaurant.application.menu;

import com.company.util.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeAdd extends DatabaseMenuItem implements MenuItem {
    public MenuItemEmployeeAdd(String itemText) {
        super(itemText);
    }

    @Override
    public void menuAction() {
        addEmployee();
    }

    private void addEmployee() {

    }
}
