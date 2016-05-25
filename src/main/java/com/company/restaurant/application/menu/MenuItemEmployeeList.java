package com.company.restaurant.application.menu;

import com.company.restaurant.model.Employee;

import java.util.ArrayList;

import static com.company.util.Util.toStringMaskNullAsEmpty;

/**
 * Created by Yevhen on 25.05.2016.
 */
public abstract class MenuItemEmployeeList extends MenuItemBasicFunctionality<Employee> implements MenuItem {
    private static final String[] employeeListHeader = new String[] {
            "Employee Id",
            "Employee first name",
            "Employee second name",
            "Employee job position",
            "Employee phone number",
            "Employee salary"
    };

    public MenuItemEmployeeList(String itemText) {
        super(itemText);
    }

    @Override
    protected String[] getListHeader() {
        return employeeListHeader;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(Employee employee) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(employee.getEmployeeId()));
        arrayList.add(employee.getFirstName());
        arrayList.add(employee.getSecondName());
        arrayList.add(employee.getJobPositionName());
        arrayList.add(employee.getPhoneNumber());
        arrayList.add(toStringMaskNullAsEmpty(employee.getSalary()));

        return arrayList.toArray(new String[arrayList.size()]);
    }
}
