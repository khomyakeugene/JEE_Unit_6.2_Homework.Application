package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.EmployeeChooser;
import com.company.restaurant.application.data.TableChooser;
import com.company.restaurant.model.Employee;
import com.company.restaurant.model.Order;
import com.company.restaurant.model.Table;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderAdd extends MenuItemOrderList implements MenuItem {
    public MenuItemOrderAdd(String itemText) {
        super(itemText);
    }

    @Override
    protected void executeAction() {
        addOrder();
    }

    @Override
    protected Order findOneObject() {
        return null;
    }

    private void addOrder() {
        String orderNumber = readOrderNumber();
        if (orderNumber != null && !orderNumber.isEmpty()) {
            Employee employee = new EmployeeChooser().chooseObjectFromList();
            if (employee != null) {
                Table table = new TableChooser().chooseObjectFromList();
                if (table != null) {
                    Order order = new Order();
                    order.setOrderNumber(orderNumber);
                    order.setEmployeeId(employee.getEmployeeId());
                    order.setTableId(table.getTableId());

                    getRestaurantController().addOrder(order);
                    dataHasBeenSuccessfullyAddedMessage();
                }
            }
        }
    }
}
