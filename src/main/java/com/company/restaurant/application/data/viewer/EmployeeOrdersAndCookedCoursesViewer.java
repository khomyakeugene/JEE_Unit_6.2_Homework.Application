package com.company.restaurant.application.data.viewer;

import com.company.restaurant.application.data.service.Executor;
import com.company.restaurant.application.data.service.ObjectProcessorProto;
import com.company.restaurant.controllers.EmployeeController;
import com.company.restaurant.model.Employee;

/**
 * Created by Yevhen on 04.07.2016.
 */
public class EmployeeOrdersAndCookedCoursesViewer
        extends ObjectProcessorProto<Employee> implements Executor {

    private EmployeeController employeeController;

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    @Override
    protected String getActionHasBeenSuccessfullyPerformedMessage(Employee object) {
        // No message at all
        return null;
    }

    @Override
    protected String processObject(Employee employee) {
        // Show employee orders

        // Show employee cooked courses


        return null;
    }
}
