package com.company.restaurant.application.menu;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeAdd extends DatabaseMenuItem implements MenuItem {
    public MenuItemEmployeeAdd(String itemText) {
        super(itemText);
    }

    @Override
    public void menuAction() {
        addEmployee();
    }

    private void addEmployee() {

    }
}
