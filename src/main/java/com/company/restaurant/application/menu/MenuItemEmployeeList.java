package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.list.EmployeeTableList;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeList extends SafeMenuItem implements MenuItem {
    private EmployeeTableList employeeTableList;

    public void setEmployeeTableList(EmployeeTableList employeeTableList) {
        this.employeeTableList = employeeTableList;
    }

    @Override
    protected void performAction() {
        employeeTableList.displayObjectList();
    }
}
