package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.adder.ObjectAdder;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;
import com.company.restaurant.model.Warehouse;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class MenuItemWarehouseAddIngredient extends SafeMenuItem implements MenuItem {
    private ObjectAdder<Warehouse> warehouseAdder;

    public void setWarehouseAdder(ObjectAdder<Warehouse> warehouseAdder) {
        this.warehouseAdder = warehouseAdder;
    }

    @Override
    protected void performAction() {
        warehouseAdder.addObjects();
    }
}
