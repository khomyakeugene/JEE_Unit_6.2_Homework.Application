package com.company.restaurant.application.menu;

import com.company.restaurant.model.Order;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderTakeCourseFromOrder extends MenuItemOrderOpenOrderOperation implements MenuItem  {
    public MenuItemOrderTakeCourseFromOrder(String itemText) {
        super(itemText);
    }

    @Override
    protected String doActionOnDatabaseObject(Order object) {
        return super.doActionOnDatabaseObject(object);
    }
}
