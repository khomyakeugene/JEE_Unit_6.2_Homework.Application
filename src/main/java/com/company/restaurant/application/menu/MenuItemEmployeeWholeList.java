package com.company.restaurant.application.menu;

import com.company.restaurant.model.Employee;
import com.company.util.Util;

import java.util.List;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeWholeList extends MenuItemEmployeeList implements MenuItem {
    public MenuItemEmployeeWholeList(String itemText) {
        super(itemText);
    }

    @Override
    protected List<Employee> findData() {
        return getRestaurantController().findAllEmployees();
    }

    @Override
    protected void executeAction() {
        EmployeeList();
    }

    private void EmployeeList() {
        tableList();
    }
}
