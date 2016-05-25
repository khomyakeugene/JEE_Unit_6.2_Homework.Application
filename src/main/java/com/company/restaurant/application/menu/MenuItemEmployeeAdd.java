package com.company.restaurant.application.menu;

import com.company.restaurant.model.Employee;
import com.company.util.Util;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeAdd extends MenuItemEmployeeFind implements MenuItem {
    private static final String ENTER_PHONE_NUMBER_MESSAGE = "Please, enter employee phone number";
    private static final String ENTER_SALARY_MESSAGE = "Please, enter employee salary";

    public MenuItemEmployeeAdd(String itemText) {
        super(itemText);
    }

    @Override
    public void menuAction() {
        addEmployee();
    }

    private void addEmployee() {
        String[] employeeName = readEmployeeName(true);

        JobPositionList jobPositionList = new JobPositionList();
        int jobPositionId = jobPositionList.readId();
        String phoneNumber = Util.readInputString(ENTER_PHONE_NUMBER_MESSAGE);
        Float salary = Util.readInputFloat(ENTER_SALARY_MESSAGE, false);

        Employee employee = new Employee();
        employee.setFirstName(employeeName[0]);
        employee.setSecondName(employeeName[1]);
        employee.setJobPositionId(jobPositionId);
        employee.setPhoneNumber(phoneNumber);
        employee.setSalary(salary);

        getRestaurantController().addEmployee(employee);
        dataHasBeenSuccessfullyAddedMessage();
    }
}
