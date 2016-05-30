package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.adder.ObjectAdder;
import com.company.restaurant.application.data.adder.OrderAdder;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;
import com.company.restaurant.model.Order;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderAdd extends SafeMenuItem implements MenuItem {
    private ObjectAdder<Order> orderAdder = OrderAdder.newInstance();

    public MenuItemOrderAdd(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        orderAdder.addObjects();
    }
}
