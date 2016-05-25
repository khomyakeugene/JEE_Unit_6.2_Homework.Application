package com.company.restaurant.application;

import com.company.restaurant.model.Employee;
import com.company.util.MenuItem;
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
        readEmployeeName();
        List<Employee> data = findData();

        if (data == null || data.size() == 0) {
            dataHasNotBeenFoundMessage();
        } else {
            boolean wasErrorDetected = false;
            for (Employee employee : data) {
                String errorMessage = getRestaurantController().delEmployee(employee);
                wasErrorDetected = errorMessage != null && !errorMessage.isEmpty();
                if (wasErrorDetected) {
                    Util.printMessage(errorMessage);
                }

            }
            if (!wasErrorDetected) {
                dataHasBeenSuccessfullyDeletedMessage();
            }
        }
    }
}
