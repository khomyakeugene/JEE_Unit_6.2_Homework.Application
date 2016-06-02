package com.company.restaurant.application.data.remover;

import com.company.restaurant.model.Employee;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class EmployeeRemover extends ObjectRemoverProto<Employee>  implements ObjectRemover<Employee>  {
    @Override
    protected String delObject(Employee employee) {
        return getRestaurantController().delEmployee(employee);
    }
}
