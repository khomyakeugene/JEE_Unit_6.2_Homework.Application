package com.company.restaurant.application.data.service;

import com.company.restaurant.application.RestaurantConsoleApplication;
import com.company.restaurant.controllers.RestaurantController;
import com.company.restaurant.model.IngredientDao;
import com.company.restaurant.model.PortionDao;
import com.company.restaurant.model.WarehouseAdapter;
import com.company.util.Util;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class DatabaseService {
    private static final String DATA_HAS_BEEN_SUCCESSFULLY_ADDED = "Data has been successfully added";
    private static final String DATA_HAS_BEEN_SUCCESSFULLY_DELETED = "Data has been successfully deleted";
    private static final String DATA_HAS_NOT_BEEN_FOUND_MESSAGE = "Data has not been found";

    private RestaurantController restaurantController;

    public void setRestaurantController(RestaurantController restaurantController) {
        this.restaurantController = restaurantController;
    }

    public RestaurantController getRestaurantController() {
        return restaurantController;
    }

    private WarehouseAdapter getWarehouseAdapter() {
        return getRestaurantController().getWarehouseAdapter();
    }

    protected PortionDao getPortionDao() {
        return getWarehouseAdapter().getPortionDao();
    }

    protected IngredientDao getIngredientDao() {
        return getWarehouseAdapter().getIngredientDao();
    }

    protected void dataHasBeenSuccessfullyAddedMessage() {
        Util.printMessage(DATA_HAS_BEEN_SUCCESSFULLY_ADDED);
    }

    protected void dataHasBeenSuccessfullyDeletedMessage() {
        Util.printMessage(DATA_HAS_BEEN_SUCCESSFULLY_DELETED);
    }

    protected void errorMessage(String message) {
        Util.printMessage(message);
    }

    protected void listDataHasNotBeenFoundMessage() {
        errorMessage(DATA_HAS_NOT_BEEN_FOUND_MESSAGE);
    }

    protected void oneObjectHasNotBeenFoundMessage() {
        errorMessage(DATA_HAS_NOT_BEEN_FOUND_MESSAGE);
    }
}
