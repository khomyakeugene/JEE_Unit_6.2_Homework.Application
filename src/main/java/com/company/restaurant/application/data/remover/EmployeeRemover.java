package com.company.restaurant.application.data.remover;

import com.company.restaurant.application.data.chooser.ObjectChooser;
import com.company.restaurant.model.Employee;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class EmployeeRemover extends ObjectRemoverProto<Employee> {
    public EmployeeRemover(ObjectChooser<Employee> objectChooser) {
        super(objectChooser);
    }

    @Override
    protected String delObject(Employee employee) {
        return getRestaurantController().delEmployee(employee);
    }
}
