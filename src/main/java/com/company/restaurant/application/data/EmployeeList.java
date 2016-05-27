package com.company.restaurant.application.data;

import com.company.restaurant.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class EmployeeList extends ExtendedDatabaseService<Employee> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter employee identifier";

    private static final String[] listHeader = new String[] {
            "Employee Id",
            "Employee name"
    };

    @Override
    protected String[] getListHeader() {
        return listHeader;
    }

    @Override
    protected Employee findOneObject() {
        return null;
    }

    @Override
    protected List<Employee> findData() {
        return getRestaurantController().findAllEmployees();
    }

    @Override
    protected String[] dataSetRowDataToStringArray(Employee employee) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(employee.getEmployeeId()));
        arrayList.add(employee.getFirstName() + " " + employee.getSecondName());

        return arrayList.toArray(new String[arrayList.size()]);
    }

    @Override
    protected boolean validateId(Integer Id) {
        return (getRestaurantController().findEmployeeById(Id) != null);
    }

    public int readId() {
        return super.readId(ENTER_IDENTIFIER_MESSAGE);
    }

}
