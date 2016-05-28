package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.chooser.OrderChooser;
import com.company.restaurant.application.data.list.OpenOrderTableList;
import com.company.restaurant.application.data.remover.OrderRemover;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderDelete extends DatabaseMenuItem implements MenuItem {
    private OrderRemover orderRemover = new OrderRemover(new OrderChooser(new OpenOrderTableList()));

    public MenuItemOrderDelete(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        orderRemover.deleteObject();
    }
}
