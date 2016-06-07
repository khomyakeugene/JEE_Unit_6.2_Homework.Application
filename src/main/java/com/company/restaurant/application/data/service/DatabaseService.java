package com.company.restaurant.application.data.service;

import com.company.restaurant.controllers.KitchenController;
import com.company.restaurant.controllers.OrderController;
import com.company.restaurant.controllers.RestaurantController;
import com.company.restaurant.controllers.WarehouseController;
import com.company.util.Util;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class DatabaseService {
    private static final String DATA_HAS_BEEN_SUCCESSFULLY_ADDED = "Data has been successfully added";
    private static final String DATA_HAS_NOT_BEEN_FOUND_MESSAGE = "Data has not been found";
    protected static final String DATA_HAS_BEEN_SUCCESSFULLY_DELETED = "Data has been successfully deleted";

    private RestaurantController restaurantController;
    private WarehouseController warehouseController;
    private KitchenController kitchenController;
    private OrderController orderController;


    public void setRestaurantController(RestaurantController restaurantController) {
        this.restaurantController = restaurantController;
    }

    public RestaurantController getRestaurantController() {
        return restaurantController;
    }

    public WarehouseController getWarehouseController() {
        return warehouseController;
    }

    public void setWarehouseController(WarehouseController warehouseController) {
        this.warehouseController = warehouseController;
    }

    protected KitchenController getKitchenController() {
        return kitchenController;
    }

    public void setKitchenController(KitchenController kitchenController) {
        this.kitchenController = kitchenController;
    }

    public OrderController getOrderController() {
        return orderController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
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
