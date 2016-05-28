package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.list.OpenOrderTableList;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderOpenOrderList extends DatabaseMenuItem implements MenuItem {
    private OpenOrderTableList openOrderTableList = new OpenOrderTableList();

    public MenuItemOrderOpenOrderList(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        openOrderTableList.displayObjectList();
    }
}
