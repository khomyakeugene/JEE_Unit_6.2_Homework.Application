package com.company.restaurant.application;

import com.company.restaurant.controllers.RestaurantController;
import com.company.util.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public abstract class DatabaseMenuItem extends SimpleMenuItem implements MenuItem {
    public DatabaseMenuItem(String itemText) {
        super(itemText);
    }

    RestaurantController getRestaurantController() {
        return RestaurantConsoleApplication.getRestaurantController();
    }
}
