package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.chooser.OrderChooser;
import com.company.restaurant.application.data.list.OpenOrderTableList;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.model.Order;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderCloseOrder extends DatabaseMenuItem implements MenuItem {
    private OrderChooser orderChooser = new OrderChooser(new OpenOrderTableList());

    public MenuItemOrderCloseOrder(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        Order order = orderChooser.chooseObjectFromList();
        if (order != null) {
            getRestaurantController().closeOrder(order);
        }
    }
}
