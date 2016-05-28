package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.chooser.JobPositionChooser;
import com.company.restaurant.application.data.list.JobPositionTableList;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.model.Employee;
import com.company.restaurant.model.JobPosition;
import com.company.util.Util;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeAdd extends DatabaseMenuItem implements MenuItem {
    private static final String ENTER_FIRST_NAME_MESSAGE = "Please, enter first name of employee";
    private static final String ENTER_SECOND_NAME_MESSAGE = "Please, enter second name of employee";
    private static final String ENTER_PHONE_NUMBER_MESSAGE = "Please, enter employee phone number";
    private static final String ENTER_SALARY_MESSAGE = "Please, enter employee salary";

    public MenuItemEmployeeAdd(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        String firstName = Util.readInputString(ENTER_FIRST_NAME_MESSAGE, true);
        String secondName = Util.readInputString(ENTER_SECOND_NAME_MESSAGE, true);
        if (firstName != null && !firstName.isEmpty() && secondName != null && !secondName.isEmpty()) {
            JobPosition jobPosition = new JobPositionChooser(new JobPositionTableList()).chooseObjectFromList();
            if (jobPosition != null) {
                String phoneNumber = Util.readInputString(ENTER_PHONE_NUMBER_MESSAGE);
                Float salary = Util.readInputFloat(ENTER_SALARY_MESSAGE, false);
                Employee employee = new Employee();
                employee.setFirstName(firstName.trim());
                employee.setSecondName(secondName.trim());
                employee.setJobPositionId(jobPosition.getId());
                employee.setPhoneNumber(phoneNumber);
                employee.setSalary(salary);

                getRestaurantController().addEmployee(employee);
                dataHasBeenSuccessfullyAddedMessage();
            }
        }
    }
}
