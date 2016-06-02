package com.company.restaurant.application.data.adder;

import com.company.restaurant.application.data.chooser.ObjectChooser;
import com.company.restaurant.model.Employee;
import com.company.restaurant.model.JobPosition;
import com.company.util.Util;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class EmployeeAdder extends ObjectAdderProto<Employee> implements ObjectAdder<Employee> {
    private static final String ENTER_FIRST_NAME_MESSAGE = "Please, enter first name of employee";
    private static final String ENTER_SECOND_NAME_MESSAGE = "Please, enter second name of employee";
    private static final String ENTER_PHONE_NUMBER_MESSAGE = "Please, enter employee phone number";
    private static final String ENTER_SALARY_MESSAGE = "Please, enter employee salary";

    private ObjectChooser<JobPosition> jobPositionChooser;

    public void setJobPositionChooser(ObjectChooser<JobPosition> jobPositionChooser) {
        this.jobPositionChooser = jobPositionChooser;
    }

    @Override
    protected Employee addObject() {
        Employee result = null;

        String firstName = Util.readInputString(ENTER_FIRST_NAME_MESSAGE, false);
        if (firstName != null && !firstName.isEmpty()) {
            String secondName = Util.readInputString(ENTER_SECOND_NAME_MESSAGE, false);
            if (secondName != null && !secondName.isEmpty()) {
                JobPosition jobPosition = jobPositionChooser.chooseObjectFromList();
                if (jobPosition != null) {
                    String phoneNumber = Util.readInputString(ENTER_PHONE_NUMBER_MESSAGE);
                    Float salary = Util.readInputPositiveFloat(ENTER_SALARY_MESSAGE, false);
                    Employee employee = new Employee();
                    employee.setFirstName(firstName.trim());
                    employee.setSecondName(secondName.trim());
                    employee.setJobPositionId(jobPosition.getId());
                    employee.setPhoneNumber(phoneNumber);
                    employee.setSalary(salary);

                    result = getRestaurantController().addEmployee(employee);
                    dataHasBeenSuccessfullyAddedMessage();
                }
            }
        }

        return result;
    }
}
