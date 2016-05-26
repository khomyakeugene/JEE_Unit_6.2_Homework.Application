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
    protected List<Order> findData() {
        return getRestaurantController().findAllOpenOrders();
    }

    @Override
    protected void executeAction() {
        openOrderList();
    }

    private void openOrderList() {
        tableList();
    }
}
