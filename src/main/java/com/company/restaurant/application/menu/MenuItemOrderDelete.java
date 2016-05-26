package com.company.restaurant.application.menu;

import com.company.restaurant.model.Order;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderDelete extends MenuItemOrderOpenOrderList implements MenuItem {
    public MenuItemOrderDelete(String itemText) {
        super(itemText);
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
        return getRestaurantController().delOrder(order);
    }

    @Override
    protected void actionHasBeenSuccessfullyPerformedMessage() {
        super.dataHasBeenSuccessfullyDeletedMessage();
    }
}
