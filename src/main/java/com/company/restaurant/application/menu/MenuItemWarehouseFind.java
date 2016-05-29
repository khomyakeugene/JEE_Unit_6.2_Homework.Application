package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.finder.WarehouseFinder;
import com.company.restaurant.application.data.list.WarehouseTableList;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class MenuItemWarehouseFind extends SafeMenuItem implements MenuItem {
    private WarehouseFinder warehouseFinder = new WarehouseFinder(new WarehouseTableList());

    public MenuItemWarehouseFind(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        warehouseFinder.findAndDisplayObjectList();
    }
}
