package com.company.restaurant.application.menu;

import com.company.restaurant.application.menu.service.MenuItem;
import com.company.util.Util;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class MenuItemWarehouseElapsingList extends MenuItemWarehouseList implements MenuItem {
    private static final String ENTER_BOUNDARY_VALUE_MESSAGE = "Please, enter boundary value";

    @Override
    protected void performAction() {
        Float boundaryValue = Util.readInputPositiveFloat(ENTER_BOUNDARY_VALUE_MESSAGE, false);
        if (boundaryValue != null) {
            warehouseTableList.displayObjectList(
                    warehouseTableList.getRestaurantController().findAllElapsingWarehouseIngredients(boundaryValue));
        }

    }
}
