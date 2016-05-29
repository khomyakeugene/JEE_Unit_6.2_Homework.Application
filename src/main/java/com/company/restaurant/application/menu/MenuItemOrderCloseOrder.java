package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.chooser.OrderChooser;
import com.company.restaurant.application.data.list.OpenOrderTableList;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.model.Order;
import com.company.util.Util;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderCloseOrder extends DatabaseMenuItem implements MenuItem {
    private static final String ORDER_HAS_BEEN_CLOSED_PATTERN = "Order with number <%s> has been closed";

    private OrderChooser orderChooser = new OrderChooser(new OpenOrderTableList());

    public MenuItemOrderCloseOrder(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        Order order = orderChooser.chooseObjectFromList();
        if (order != null) {
            getRestaurantController().closeOrder(order);
            Util.printMessage(String.format(ORDER_HAS_BEEN_CLOSED_PATTERN, order.getOrderNumber()));
        }
    }
}
