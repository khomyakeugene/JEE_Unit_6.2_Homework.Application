package com.company.restaurant.application.menu;

import com.company.restaurant.application.RestaurantConsoleApplication;
import com.company.restaurant.controllers.RestaurantController;

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
