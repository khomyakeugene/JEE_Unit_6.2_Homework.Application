package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.finder.EmployeeFinder;
import com.company.restaurant.application.data.list.EmployeeTableList;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeFind extends DatabaseMenuItem implements MenuItem {
    private EmployeeFinder employeeFinder = new EmployeeFinder(new EmployeeTableList());

    public MenuItemEmployeeFind(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        employeeFinder.findAndDisplayObjectList();
    }
}
