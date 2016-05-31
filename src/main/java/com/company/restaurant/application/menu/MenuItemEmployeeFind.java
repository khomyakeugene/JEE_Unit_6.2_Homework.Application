package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.finder.EmployeeFinder;
import com.company.restaurant.application.data.list.EmployeeTableList;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeFind extends SafeMenuItem implements MenuItem {
    private EmployeeFinder employeeFinder = new EmployeeFinder(new EmployeeTableList());

    @Override
    protected void performAction() {
        employeeFinder.findAndDisplayObjectList();
    }
}
