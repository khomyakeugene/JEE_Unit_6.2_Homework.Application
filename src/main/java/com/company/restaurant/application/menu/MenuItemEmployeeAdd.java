package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.JobPositionChooser;
import com.company.restaurant.model.Employee;
import com.company.restaurant.model.JobPosition;
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
    protected void executeAction() {
        addEmployee();
    }

    private void addEmployee() {
        String[] employeeName = readEmployeeName(true);
        String firstName = employeeName[0];
        String secondName = employeeName[1];
        if (firstName != null && !firstName.isEmpty() && secondName != null && !secondName.isEmpty()) {
            JobPosition jobPosition = new JobPositionChooser().chooseObjectFromList();
            if (jobPosition != null) {
                String phoneNumber = Util.readInputString(ENTER_PHONE_NUMBER_MESSAGE);
                Float salary = Util.readInputFloat(ENTER_SALARY_MESSAGE, false);
                Employee employee = new Employee();
                employee.setFirstName(firstName);
                employee.setSecondName(secondName);
                employee.setJobPositionId(jobPosition.getId());
                employee.setPhoneNumber(phoneNumber);
                employee.setSalary(salary);

                getRestaurantController().addEmployee(employee);
                dataHasBeenSuccessfullyAddedMessage();
            }
        }
    }
}
