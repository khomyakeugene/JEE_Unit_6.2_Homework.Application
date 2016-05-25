package com.company.restaurant.application;

import com.company.util.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeList extends SimpleMenuItem implements MenuItem {
    public MenuItemEmployeeList(String itemText) {
        super(itemText);
    }

    @Override
    public void menuAction() {
        EmployeeList();
    }

    private void EmployeeList() {

    }
}
