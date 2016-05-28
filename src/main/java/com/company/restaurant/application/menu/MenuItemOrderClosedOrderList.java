package com.company.restaurant.application.menu;

import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.model.Order;

import java.util.List;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderClosedOrderList extends MenuItemOrderList implements MenuItem {
    public MenuItemOrderClosedOrderList(String itemText) {
        super(itemText);
    }

    @Override
    protected Order findOneObject() {
        return null;
    }

    @Override
    protected List<Order> findData() {
        return getRestaurantController().findAllClosedOrders();
    }

    @Override
    protected void executeAction() {
        closedOrderList();
    }

    private void closedOrderList() {
        tableList();
    }
}
