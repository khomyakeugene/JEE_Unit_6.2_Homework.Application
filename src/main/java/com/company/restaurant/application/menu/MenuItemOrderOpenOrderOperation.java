package com.company.restaurant.application.menu;

import com.company.restaurant.model.Order;

import java.util.List;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderOpenOrderOperation extends MenuItemOrderList implements MenuItem  {
    public MenuItemOrderOpenOrderOperation(String itemText) {
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
    protected boolean initialListCanBeEmpty() {
        return false;
    }

    @Override
    protected void readObjectKeyData() {
        readOrderId();
    }
}
