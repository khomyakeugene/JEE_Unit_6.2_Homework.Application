package com.company.restaurant.application.menu.service;

import com.company.restaurant.application.data.service.DatabaseService;
import com.company.restaurant.controllers.RestaurantController;

/**
 * Created by Yevhen on 28.05.2016.
 */
public abstract class DatabaseMenuItem extends SafeMenuItem implements MenuItem {
    private DatabaseService databaseService = new DatabaseService();

    public DatabaseMenuItem(String itemText) {
        super(itemText);
    }

    public RestaurantController getRestaurantController() {
        return databaseService.getRestaurantController();
    }
}
