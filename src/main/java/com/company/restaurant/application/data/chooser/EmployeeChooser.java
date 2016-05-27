package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.service.ObjectChooserProto;
import com.company.restaurant.application.data.service.ObjectTableList;
import com.company.restaurant.model.Employee;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class EmployeeChooser extends ObjectChooserProto<Employee, Integer> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter employee identifier";

    public EmployeeChooser(ObjectTableList<Employee> objectTableList) {
        super(objectTableList);
    }

    @Override
    protected Employee findObject(Integer employeeId) {
        return getRestaurantController().findEmployeeById(employeeId);
    }

    @Override
    protected Integer readObjectKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }


    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }
}
