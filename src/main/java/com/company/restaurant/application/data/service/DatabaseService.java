package com.company.restaurant.application.data.service;

import com.company.restaurant.application.RestaurantConsoleApplication;
import com.company.restaurant.controllers.RestaurantController;
import com.company.util.Util;
import com.sun.org.apache.bcel.internal.generic.PUSH;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class DatabaseService {
    private static final String ACTION_HAS_BEEN_SUCCESSFULLY_PERFORMED = "The action has been successfully performed";
    private static final String DATA_HAS_BEEN_SUCCESSFULLY_ADDED = "Data has been successfully added";
    private static final String DATA_HAS_BEEN_SUCCESSFULLY_DELETED = "Data has been successfully deleted";
    private static final String DATA_HAS_NOT_BEEN_FOUND_MESSAGE = "Data has not been found";

    public RestaurantController getRestaurantController() {
        return RestaurantConsoleApplication.getRestaurantController();
    }

    public void dataHasBeenSuccessfullyAddedMessage() {
        Util.printMessage(DATA_HAS_BEEN_SUCCESSFULLY_ADDED);
    }

    public void actionHasBeenSuccessfullyPerformedMessage() {
        Util.printMessage(ACTION_HAS_BEEN_SUCCESSFULLY_PERFORMED);
    }

    public void dataHasBeenSuccessfullyDeletedMessage() {
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
