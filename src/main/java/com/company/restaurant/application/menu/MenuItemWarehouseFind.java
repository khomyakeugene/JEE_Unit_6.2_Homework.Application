package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.finder.ObjectFinder;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;
import com.company.restaurant.model.Warehouse;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class MenuItemWarehouseFind extends SafeMenuItem implements MenuItem {
    private ObjectFinder<Warehouse> warehouseFinder;

    public void setWarehouseFinder(ObjectFinder<Warehouse> warehouseFinder) {
        this.warehouseFinder = warehouseFinder;
    }

    @Override
    protected void performAction() {
        warehouseFinder.findAndDisplayObjectList();
    }
}
