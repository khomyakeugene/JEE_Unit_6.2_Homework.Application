package com.company.restaurant.application.data;

import com.company.restaurant.application.RestaurantConsoleApplication;
import com.company.restaurant.controllers.RestaurantController;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class DatabaseService {
    public RestaurantController getRestaurantController() {
        return RestaurantConsoleApplication.getRestaurantController();
    }
}
