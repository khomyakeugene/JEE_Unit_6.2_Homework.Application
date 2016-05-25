package com.company.restaurant.application;

import com.company.restaurant.model.Employee;
import com.company.util.MenuItem;
import com.company.util.Util;

import java.util.List;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeFind extends MenuItemEmployeeList implements MenuItem {
    private static final String ENTER_FIRST_NAME_MESSAGE = "Please, enter first name of employee";
    private static final String ENTER_SECOND_NAME_MESSAGE = "Please, enter second name of employee";

    private String firstName;
    private String secondName;

    public MenuItemEmployeeFind(String itemText) {
        super(itemText);
    }

    @Override
    protected Employee findOneObject() {
        return null;
    }

    @Override
    protected List<Employee> findData() {
        return getRestaurantController().findEmployeeByFirstAndSecondName(firstName, secondName);
    }

    @Override
    public void menuAction() {
        findEmployee();
    }

    protected String[] readEmployeeName() {
        firstName = Util.readInputString(ENTER_FIRST_NAME_MESSAGE).trim();
        secondName = Util.readInputString(ENTER_SECOND_NAME_MESSAGE).trim();

        return new String[] {firstName, secondName};
    }


    private void findEmployee() {
        readEmployeeName();
        tableList();
    }
}
