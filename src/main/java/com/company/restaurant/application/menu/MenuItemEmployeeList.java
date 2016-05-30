package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.list.EmployeeTableList;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeList extends SafeMenuItem implements MenuItem {
    private EmployeeTableList employeeTableList = new EmployeeTableList();

    public MenuItemEmployeeList(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        employeeTableList.displayObjectList();
    }
}
