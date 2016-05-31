package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.remover.ObjectRemover;
import com.company.restaurant.application.data.remover.OrderRemover;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;
import com.company.restaurant.model.Order;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderDelete extends SafeMenuItem implements MenuItem {
    private ObjectRemover<Order> orderRemover = OrderRemover.newInstance();

    @Override
    protected void performAction() {
        orderRemover.deleteObjects();
    }
}
