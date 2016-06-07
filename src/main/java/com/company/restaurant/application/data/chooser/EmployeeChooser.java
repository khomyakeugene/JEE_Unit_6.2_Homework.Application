package com.company.restaurant.application.data.chooser;

import com.company.restaurant.model.Employee;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class EmployeeChooser extends ObjectChooserProto<Employee, Integer> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter employee identifier";

    @Override
    protected Employee findObject(Integer employeeId) {
        return getEmployeeController().findEmployeeById(employeeId);
    }

    @Override
    protected Integer readKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }


    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }
}
