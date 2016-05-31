package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.converter.OrderCloser;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderCloseOrder extends SafeMenuItem implements MenuItem {
    private OrderCloser orderCloser = new OrderCloser();

    @Override
    protected void performAction() {
        orderCloser.closeOrder();
    }
}
