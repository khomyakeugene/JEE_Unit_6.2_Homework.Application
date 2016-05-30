package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.adder.EmployeeAdder;
import com.company.restaurant.application.data.adder.ObjectAdder;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;
import com.company.restaurant.model.Employee;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeAdd extends SafeMenuItem implements MenuItem {
    private ObjectAdder<Employee> employeeAdder = EmployeeAdder.newInstance();

    public MenuItemEmployeeAdd(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        employeeAdder.addObjects();
    }
}
