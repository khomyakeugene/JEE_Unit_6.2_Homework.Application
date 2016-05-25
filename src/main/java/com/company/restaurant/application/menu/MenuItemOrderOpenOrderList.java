package com.company.restaurant.application.menu;

import com.company.restaurant.model.Order;

import java.util.List;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderOpenOrderList extends MenuItemOrderList implements MenuItem {
    public MenuItemOrderOpenOrderList(String itemText) {
        super(itemText);
    }

    @Override
    protected Order findOneObject() {
        return null;
    }

    @Override
    protected List<Order> findData() {
        return getRestaurantController().findAllOpenOrders();
    }

    @Override
    public void menuAction() {
        openOrderList();
    }

    private void openOrderList() {
        tableList();
    }
}
