package com.company.restaurant.application.menu;

import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.model.Order;
import com.company.util.Util;

import java.util.List;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderOpenOrderOperation extends MenuItemOrderList implements MenuItem {
    private static final String OPEN_ORDERS_HAVE_NOT_BEEN_FOUND_MESSAGE = "Open orders have not been found";

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

    protected void listDataHasNotBeenFoundMessage() {
        Util.printMessage(OPEN_ORDERS_HAVE_NOT_BEEN_FOUND_MESSAGE);
    }

}
