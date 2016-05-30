package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.list.EmployeeTableList;
import com.company.restaurant.application.data.list.ObjectTableList;
import com.company.restaurant.model.Employee;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class EmployeeChooser extends ObjectChooserProto<Employee, Integer> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter employee identifier";

    private EmployeeChooser(ObjectTableList<Employee> objectTableList) {
        super(objectTableList);
    }



    @Override
    protected Employee findObject(Integer employeeId) {
        return getRestaurantController().findEmployeeById(employeeId);
    }

    @Override
    protected Integer readKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }


    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }

    public static ObjectChooser<Employee> newInstance() {
        return new EmployeeChooser(new EmployeeTableList());
    }
}
