package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.chooser.EmployeeChooser;
import com.company.restaurant.application.data.chooser.TableChooser;
import com.company.restaurant.application.data.list.EmployeeTableList;
import com.company.restaurant.application.data.list.TableTableList;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.model.Employee;
import com.company.restaurant.model.Order;
import com.company.restaurant.model.Table;
import com.company.util.Util;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderAdd extends DatabaseMenuItem implements MenuItem {
    private static final String ENTER_ORDER_NUMBER_MESSAGE = "Please, enter order number";

    private EmployeeChooser employeeChooser = new EmployeeChooser(new EmployeeTableList());
    private TableChooser tableChooser = new TableChooser(new TableTableList());

    public MenuItemOrderAdd(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        String orderNumber = Util.readInputString(ENTER_ORDER_NUMBER_MESSAGE);
        if (orderNumber != null && !orderNumber.isEmpty()) {
            Employee employee = employeeChooser.chooseObjectFromList();
            if (employee != null) {
                Table table = tableChooser.chooseObjectFromList();
                if (table != null) {
                    Order order = new Order();
                    order.setOrderNumber(orderNumber.trim());
                    order.setEmployeeId(employee.getEmployeeId());
                    order.setTableId(table.getTableId());

                    getRestaurantController().addOrder(order);
                    dataHasBeenSuccessfullyAddedMessage();
                }
            }
        }
    }
}
