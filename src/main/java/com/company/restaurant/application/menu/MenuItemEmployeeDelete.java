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
    public MenuItemEmployeeDelete(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        new EmployeeRemover(new EmployeeChooser(new EmployeeTableList())).deleteObject();
    }
}
