package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.chooser.EmployeeChooser;
import com.company.restaurant.application.data.list.EmployeeTableList;
import com.company.restaurant.application.data.remover.EmployeeRemover;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeDelete extends DatabaseMenuItem implements MenuItem {
    private EmployeeRemover employeeRemover = new EmployeeRemover(new EmployeeChooser(new EmployeeTableList()));

    public MenuItemEmployeeDelete(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        employeeRemover.deleteObject();
    }
}
