package com.company.restaurant.application;

import com.company.util.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeAdd extends SimpleMenuItem implements MenuItem {
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
