package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.list.WarehouseTableList;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;
import com.company.util.Util;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class MenuItemWarehouseElapsingList extends SafeMenuItem implements MenuItem {
    private static final String ENTER_BOUNDARY_VALUE_MESSAGE = "Please, enter boundary value";

    private WarehouseTableList warehouseTableList = new WarehouseTableList();

    @Override
    protected void performAction() {
        Float boundaryValue = Util.readInputPositiveFloat(ENTER_BOUNDARY_VALUE_MESSAGE, false);
        if (boundaryValue != null) {
            warehouseTableList.displayObjectList(
                    warehouseTableList.getRestaurantController().findAllElapsingWarehouseIngredients(boundaryValue));
        }

    }
}
