package com.company.restaurant.application.menu;

import com.company.restaurant.model.Employee;
import com.company.util.Util;

import java.util.List;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmployeeDelete extends MenuItemEmployeeFind implements MenuItem {
    public MenuItemEmployeeDelete(String itemText) {
        super(itemText);
    }

    @Override
    public void menuAction() {
        deleteEmployee();
    }

    private void deleteEmployee() {
        // Show all data
        tableList();

        String[] employeeName = readEmployeeName();
        List<Employee> data = findData();

        if (data == null || data.size() == 0) {
            dataHasNotBeenFoundMessage();
        } else {
            if (!employeeName[0].isEmpty() || !employeeName[1].isEmpty()) {
                boolean wasErrorDetected;
                boolean someDataWasSuccessfullyDeleted = false;
                for (Employee employee : data) {
                    String errorMessage = getRestaurantController().delEmployee(employee);
                    wasErrorDetected = errorMessage != null && !errorMessage.isEmpty();
                    if (wasErrorDetected) {
                        Util.printMessage(errorMessage);
                    } else {
                        someDataWasSuccessfullyDeleted = true;
                    }
                }
                if (someDataWasSuccessfullyDeleted) {
                    dataHasBeenSuccessfullyDeletedMessage();
                }
            }
        }
    }
}
