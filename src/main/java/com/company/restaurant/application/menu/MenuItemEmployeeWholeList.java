package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.list.EmployeeTableList;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeWholeList extends DatabaseMenuItem implements MenuItem {
    public MenuItemEmployeeWholeList(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        new EmployeeTableList().displayObjectList();
    }
}
