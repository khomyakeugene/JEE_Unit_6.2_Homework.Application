package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.chooser.ObjectChooser;
import com.company.restaurant.application.data.chooser.OrderChooser;
import com.company.restaurant.application.data.service.DatabaseService;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;
import com.company.restaurant.model.Order;
import com.company.util.Util;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderCloseOrder extends SafeMenuItem implements MenuItem {
    private static final String ORDER_HAS_BEEN_CLOSED_PATTERN = "Order with number <%s> has been closed";

    private DatabaseService databaseService = new DatabaseService();
    private ObjectChooser<Order> orderChooser = OrderChooser.newInstance();

    @Override
    protected void performAction() {
        Order order = orderChooser.chooseObjectFromList();
        if (order != null) {
            databaseService.getRestaurantController().closeOrder(order);
            Util.printMessage(String.format(ORDER_HAS_BEEN_CLOSED_PATTERN, order.getOrderNumber()));
        }
    }
}
