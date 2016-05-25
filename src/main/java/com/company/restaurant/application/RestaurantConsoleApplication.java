package com.company.restaurant.application;

import com.company.restaurant.controllers.RestaurantController;
import com.company.util.Util;

import java.util.HashMap;

/**
 * Created by Yevhen on 24.05.2016.
 */
public class RestaurantConsoleApplication {
    private static final String TITLE_MESSAGE = "Welcome to the restaurant application!";
    private static final String CHOOSE_ACTIVITY_MESSAGE = "Please, choose an activity code:";
    private static final String FAREWELL_MESSAGE = "Thank you for use our application";

    private static final int MAIN_MENU_ITEM_EMPLOYEE_CODE = 1;
    private static final int MAIN_MENU_ITEM_COURSE_CODE = 2;
    private static final int MAIN_MENU_ITEM_MENU_CODE = 3;
    private static final int MAIN_MENU_ITEM_ORDER_CODE = 4;
    private static final int MAIN_MENU_ITEM_KITCHEN_CODE = 5;
    private static final int MAIN_MENU_ITEM_WAREHOUSE_CODE = 6;
    private static final int MAIN_MENU_ITEM_EXIT_CODE = 7;
    private static final HashMap<Integer, String> mainMenuMap = new HashMap<Integer, String>(){
        {
            put(MAIN_MENU_ITEM_EMPLOYEE_CODE, "Employee operations");
            put(MAIN_MENU_ITEM_COURSE_CODE, "Course operations");
            put(MAIN_MENU_ITEM_MENU_CODE, "Menu operations");
            put(MAIN_MENU_ITEM_ORDER_CODE, "Order operations");
            put(MAIN_MENU_ITEM_KITCHEN_CODE, "Kitchen operations");
            put(MAIN_MENU_ITEM_WAREHOUSE_CODE, "Warehouse operations");
            put(MAIN_MENU_ITEM_EXIT_CODE, "Exit");
        }
    };


    private static final HashMap<Integer, MenuItem> mainMenuMenuItemMap = new HashMap<Integer, MenuItem>(){
        {
            put(MAIN_MENU_ITEM_EMPLOYEE_CODE, new MenuItem() {
                @Override
                public String menuText() {
                    return "Employee operations";
                }

                @Override
                public void menuAction() {
                    employeeActivity();
                }
            } );
        }
    };


    private static final int EMPLOYEE_MENU_ITEM_ADD_CODE = 1;
    private static final int EMPLOYEE_MENU_ITEM_DELETE_CODE = 2;
    private static final int EMPLOYEE_MENU_ITEM_FIND_CODE = 3;
    private static final int EMPLOYEE_MENU_ITEM_LIST_CODE = 4;
    private static final int EMPLOYEE_MENU_ITEM_EXIT_CODE = 5;
    private static final HashMap<Integer, String> employeeMenuMap = new HashMap<Integer, String>(){
        {
            put(EMPLOYEE_MENU_ITEM_ADD_CODE, "Add employee");
            put(EMPLOYEE_MENU_ITEM_DELETE_CODE, "Delete employee");
            put(EMPLOYEE_MENU_ITEM_FIND_CODE, "Find employee by name");
            put(EMPLOYEE_MENU_ITEM_LIST_CODE, "All employee list");
            put(EMPLOYEE_MENU_ITEM_EXIT_CODE, "Exit from employee menu");
        }
    };

    private RestaurantController restaurantController;

    public void setRestaurantController(RestaurantController restaurantController) {
        this.restaurantController = restaurantController;
    }

    private int chooseMainMenuItemCode() {
        return Util.chooseMenuItemCode(CHOOSE_ACTIVITY_MESSAGE, mainMenuMap);
    }

    private void mainMenuProcess() {
        int menuItemCode;

        do {
            menuItemCode = chooseMainMenuItemCode();
            if (menuItemCode != MAIN_MENU_ITEM_EXIT_CODE) {
                mainMenuActivity(menuItemCode);
            }
        } while (menuItemCode != MAIN_MENU_ITEM_EXIT_CODE);
    }

    public void run() {
        Util.printMessage(TITLE_MESSAGE);

        mainMenuProcess();

        Util.printMessage(FAREWELL_MESSAGE);
    }

    private void mainMenuActivity(int activityCode) {
        switch (activityCode) {
            case MAIN_MENU_ITEM_EMPLOYEE_CODE:
                employeeActivity();
                break;

            case MAIN_MENU_ITEM_COURSE_CODE:
                courseActivity();
                break;

            case MAIN_MENU_ITEM_MENU_CODE:
                menuActivity();
                break;

            case MAIN_MENU_ITEM_ORDER_CODE:
                orderActivity();
                break;

            case MAIN_MENU_ITEM_KITCHEN_CODE:
                kitchenActivity();
                break;

            case MAIN_MENU_ITEM_WAREHOUSE_CODE:
                warehouseActivity();
                break;

            default:
                break;
        }
    }

    private static void employeeActivity() {
        int menuItemCode;

        do {
            menuItemCode = Util.chooseMenuItemCode(CHOOSE_ACTIVITY_MESSAGE, employeeMenuMap);
            if (menuItemCode != EMPLOYEE_MENU_ITEM_EXIT_CODE) {
                employeeMenuActivity(menuItemCode);
            }
        } while (menuItemCode != EMPLOYEE_MENU_ITEM_EXIT_CODE);
    }

    private static void employeeMenuActivity(int activityCode) {
        switch (activityCode) {
            case EMPLOYEE_MENU_ITEM_ADD_CODE:
                break;

            case EMPLOYEE_MENU_ITEM_DELETE_CODE:
                break;

            case EMPLOYEE_MENU_ITEM_FIND_CODE:
                break;

            case EMPLOYEE_MENU_ITEM_LIST_CODE:
                break;

            default:
                break;
        }
    }

    private void courseActivity() {

    }

    private void menuActivity() {

    }

    private void orderActivity() {

    }

    private void kitchenActivity() {

    }

    private void warehouseActivity() {

    }
}
