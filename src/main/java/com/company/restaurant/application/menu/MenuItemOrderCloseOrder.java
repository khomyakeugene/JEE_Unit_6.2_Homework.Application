package com.company.restaurant.application.menu;

import com.company.restaurant.model.Employee;
import com.company.restaurant.model.Order;

import java.util.List;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderCloseOrder extends MenuItemOrderList implements MenuItem {
    public MenuItemOrderCloseOrder(String itemText) {
        super(itemText);
    }

    @Override
    protected List<Order> findData() {
        return getRestaurantController().findAllOpenOrders();
    }

    @Override
    protected Order findOneObject() {
        return getRestaurantController().findOrderById(orderId);
    }

    @Override
    protected void readObjectKeyData() {
        readOrderId();
    }

    @Override
    protected String doActionOnDatabaseObject(Order order) {
        getRestaurantController().closeOrder(order);

        return null;
    }
}
