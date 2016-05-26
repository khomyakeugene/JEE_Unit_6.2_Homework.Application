package com.company.restaurant.application.menu;

import com.company.restaurant.model.Employee;
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
    protected List<Employee> findData() {
        return getRestaurantController().findEmployeeByFirstAndSecondName(firstName, secondName);
    }

    protected String[] readEmployeeName(boolean checkNotEmpty) {
        firstName = Util.readInputString(ENTER_FIRST_NAME_MESSAGE, checkNotEmpty).trim();
        secondName = Util.readInputString(ENTER_SECOND_NAME_MESSAGE, checkNotEmpty).trim();

        return new String[] {firstName, secondName};
    }

    protected String[] readEmployeeName() {
        return readEmployeeName(false);
    }


    @Override
    protected void showInitialList() {
    }

    @Override
    protected void readObjectKeyData() {
        readEmployeeName();
    }

    @Override
    protected String doActionOnDatabaseObject(Employee employee) {
        tableList();

        return null;
    }

    @Override
    protected void actionHasBeenSuccessfullyPerformedMessage() {
    }
}
