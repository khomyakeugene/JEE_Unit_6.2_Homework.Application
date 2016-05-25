package com.company.restaurant.application.menu;

import com.company.restaurant.model.Course;
import com.company.restaurant.model.Menu;
import com.company.restaurant.model.Order;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderAdd extends MenuItemOrderList implements MenuItem {
    public MenuItemOrderAdd(String itemText) {
        super(itemText);
    }

    @Override
    protected Order findOneObject() {
        return null;
    }

    @Override
    public void menuAction() {
        addOrder();
    }

    private void addOrder() {
        String orderNumber = readOrderNumber();
        if (orderNumber != null && !orderNumber.isEmpty()) {
            int employeeId = new EmployeeList().readId();
            int tableId = new TableList().readId();

            Order order = new Order();
            order.setOrderNumber(orderNumber);
            order.setEmployeeId(employeeId);
            order.setTableId(tableId);

            try {
                getRestaurantController().addOrder(order);
                dataHasBeenSuccessfullyAddedMessage();
            } catch (Exception e) {
                errorMessage(e.getMessage());
            }
        }
    }
}
