package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.list.ClosedOrderTableList;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderClosedOrderList extends DatabaseMenuItem implements MenuItem {
    private ClosedOrderTableList closedOrderTableList = new ClosedOrderTableList();

    public MenuItemOrderClosedOrderList(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        closedOrderTableList.displayObjectList();
    }
}
