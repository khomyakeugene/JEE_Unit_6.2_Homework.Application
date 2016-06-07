package com.company.restaurant.application.data.remover;

import com.company.restaurant.model.Employee;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class EmployeeRemover extends ObjectRemoverProto<Employee> {
    @Override
    protected String deleteObject(Employee employee) {
        return getEmployeeController().delEmployee(employee);
    }
}
