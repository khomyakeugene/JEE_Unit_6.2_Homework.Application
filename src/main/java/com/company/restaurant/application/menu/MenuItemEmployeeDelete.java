package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.remover.EmployeeRemover;
import com.company.restaurant.application.data.remover.ObjectRemover;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.model.Employee;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeDelete extends DatabaseMenuItem implements MenuItem {
    private ObjectRemover<Employee> employeeRemover = EmployeeRemover.newInstance();

    public MenuItemEmployeeDelete(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        employeeRemover.deleteObject();
    }
}
