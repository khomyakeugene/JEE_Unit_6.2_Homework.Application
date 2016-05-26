package com.company.restaurant.application.menu;

import com.company.restaurant.model.Order;
import com.company.util.Util;

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
    protected Order readDeletingItemKeyData() {
        readOrderId();

        return null;
    }

    @Override
    protected String deleteObjectFromDatabase(Order order) {
        return getRestaurantController().delOrder(order);
    }

    @Override
    public void menuAction() {
        deleteObject();
    }
}
