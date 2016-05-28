package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.list.EmployeeTableList;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeList extends DatabaseMenuItem implements MenuItem {
    private EmployeeTableList employeeTableList = new EmployeeTableList();

    public MenuItemEmployeeList(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        employeeTableList.displayObjectList();
    }
}
