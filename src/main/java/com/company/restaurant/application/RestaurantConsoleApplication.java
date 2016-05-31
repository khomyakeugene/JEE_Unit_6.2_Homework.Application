package com.company.restaurant.application;

import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.controllers.RestaurantController;
import com.company.util.Util;

/**
 * Created by Yevhen on 24.05.2016.
 */
public class RestaurantConsoleApplication {
    private static final String TITLE_MESSAGE = "Welcome to the restaurant application!";
    private static final String FAREWELL_MESSAGE = "Thank you for use our application";
/*

    private static final int WAREHOUSE_MENU_ITEM_CODE_ADD = 1;
    private static final int WAREHOUSE_MENU_ITEM_CODE_DELETE = 2;
    private static final int WAREHOUSE_MENU_ITEM_CODE_FIND = 3;
    private static final int WAREHOUSE_MENU_ITEM_CODE_LIST = 4;
    private static final int WAREHOUSE_MENU_ITEM_CODE_ELAPSING_LIST = 5;
    private static final int WAREHOUSE_MENU_ITEM_CODE_EXIT = 6;
    private static final String WAREHOUSE_MENU_ITEM_TEXT_ADD = "Add ingredient to warehouse";
    private static final String WAREHOUSE_MENU_ITEM_TEXT_DELETE = "Take ingredient from warehouse";
    private static final String WAREHOUSE_MENU_ITEM_TEXT_FIND = "Find ingredient in warehouse by name";
    private static final String WAREHOUSE_MENU_ITEM_TEXT_LIST = "Get warehouse ingredient list";
    private static final String WAREHOUSE_MENU_ITEM_TEXT_ELAPSING_LIST = "Get elapsing warehouse ingredient list";
    private static final HashMap<Integer, MenuItem> warehouseMenuMap = new HashMap<Integer, MenuItem>(){
        {
            put(WAREHOUSE_MENU_ITEM_CODE_ADD, new MenuItemWarehouseAddIngredient(WAREHOUSE_MENU_ITEM_TEXT_ADD));
            put(WAREHOUSE_MENU_ITEM_CODE_DELETE, new MenuItemWarehouseTakeIngredient(WAREHOUSE_MENU_ITEM_TEXT_DELETE));
            put(WAREHOUSE_MENU_ITEM_CODE_FIND, new MenuItemWarehouseFind(WAREHOUSE_MENU_ITEM_TEXT_FIND));
            put(WAREHOUSE_MENU_ITEM_CODE_LIST, new MenuItemWarehouseList(WAREHOUSE_MENU_ITEM_TEXT_LIST));
            put(WAREHOUSE_MENU_ITEM_CODE_ELAPSING_LIST, new MenuItemWarehouseElapsingList(WAREHOUSE_MENU_ITEM_TEXT_ELAPSING_LIST));
            put(WAREHOUSE_MENU_ITEM_CODE_EXIT, new MenuItemEmptyAction(MENU_ITEM_TEXT_EXIT));
        }
    };
    */

    private static RestaurantController staticRestaurantController;
    private MenuItem mainMenu;

    public void setMainMenu(MenuItem mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void setRestaurantController(RestaurantController restaurantController) {
        staticRestaurantController = restaurantController;
    }

    public static RestaurantController getRestaurantController() {
        return staticRestaurantController;
    }

    private void mainMenuProcess() {
        mainMenu.performSubMenu();
    }

    public void run() {
        Util.printMessage(TITLE_MESSAGE);
        mainMenuProcess();
        Util.printMessage(FAREWELL_MESSAGE);
    }
}
