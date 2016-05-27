package com.company.restaurant.application.data;

import com.company.restaurant.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class EmployeeChooser extends ObjectChooser<Employee, Integer> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter employee identifier";

    private static final String[] listHeader = new String[] {
            "Employee Id",
            "Employee name"
    };

    @Override
    protected Employee findObject(Integer employeeId) {
        return getRestaurantController().findEmployeeById(employeeId);
    }

    @Override
    protected Integer readObjectKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }

    @Override
    protected List<Employee> prepareObjectList() {
        return getRestaurantController().findAllEmployees();
    }

    @Override
    protected String[] getListHeader() {
        return listHeader;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(Employee employee) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(employee.getEmployeeId()));
        arrayList.add(employee.getFirstName() + " " + employee.getSecondName());

        return arrayList.toArray(new String[arrayList.size()]);
    }

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }
}
