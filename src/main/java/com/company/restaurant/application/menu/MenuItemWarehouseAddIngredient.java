package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.adder.ObjectAdder;
import com.company.restaurant.application.data.adder.WarehouseAdder;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;
import com.company.restaurant.model.Warehouse;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class MenuItemWarehouseAddIngredient extends SafeMenuItem implements MenuItem {
    private ObjectAdder<Warehouse> warehouseAdder = WarehouseAdder.newInstance();

    @Override
    protected void performAction() {
        warehouseAdder.addObjects();
    }
}
