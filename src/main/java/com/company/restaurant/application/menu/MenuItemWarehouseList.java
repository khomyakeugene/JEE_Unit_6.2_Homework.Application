package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.list.WarehouseTableList;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class MenuItemWarehouseList extends SafeMenuItem implements MenuItem {
    private WarehouseTableList warehouseTableList = new WarehouseTableList();

    @Override
    protected void performAction() {
        warehouseTableList.displayObjectList();
    }
}
