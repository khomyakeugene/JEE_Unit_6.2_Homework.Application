package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.finder.ObjectFinder;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;
import com.company.restaurant.model.Employee;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeFind extends SafeMenuItem implements MenuItem {
    private ObjectFinder<Employee> employeeFinder;

    public void setEmployeeFinder(ObjectFinder<Employee> employeeFinder) {
        this.employeeFinder = employeeFinder;
    }

    @Override
    protected void performAction() {
        employeeFinder.findAndDisplayObjectList();
    }
}
