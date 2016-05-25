package com.company.restaurant.application;

import com.company.restaurant.application.menu.*;
import com.company.restaurant.controllers.RestaurantController;
import com.company.util.MenuItem;
import com.company.util.Util;

import java.util.HashMap;

/**
 * Created by Yevhen on 24.05.2016.
 */
public class RestaurantConsoleApplication {
    private static final String TITLE_MESSAGE = "Welcome to the restaurant application!";
    private static final String CHOOSE_ACTIVITY_MESSAGE = "Please, choose an activity code:";
    private static final String FAREWELL_MESSAGE = "Thank you for use our application";
    private static final String MENU_ITEM_TEXT_EXIT = "Exit";

    private static final int MAIN_MENU_ITEM_CODE_EMPLOYEE = 1;
    private static final int MAIN_MENU_ITEM_CODE_COURSE = 2;
    private static final int MAIN_MENU_ITEM_CODE_MENU = 3;
    private static final int MAIN_MENU_ITEM_CODE_ORDER = 4;
    private static final int MAIN_MENU_ITEM_CODE_KITCHEN = 5;
    private static final int MAIN_MENU_ITEM_CODE_WAREHOUSE = 6;
    private static final int MAIN_MENU_ITEM_CODE_EXIT = 7;
    private static final String MAIN_MENU_ITEM_TEXT_EMPLOYEE_OPERATIONS = "Employee operations";
    private static final String MAIN_MENU_ITEM_TEXT_COURSE_OPERATIONS = "Course operations";
    private static final String MAIN_MENU_ITEM_TEXT_MENU_OPERATIONS = "Menu operations";
    private static final String MAIN_MENU_ITEM_TEXT_ORDER_OPERATIONS = "Order operations";
    private static final String MAIN_MENU_ITEM_TEXT_KITCHEN_OPERATIONS = "Kitchen operations";
    private static final String MAIN_MENU_ITEM_TEXT_WAREHOUSE_OPERATIONS = "Warehouse operations";
    private static final HashMap<Integer, MenuItem> mainMenuItemMap = new HashMap<Integer, MenuItem>(){
        {
            put(MAIN_MENU_ITEM_CODE_EMPLOYEE, new MenuItem() {
                @Override
                public String getItemText() {
                    return MAIN_MENU_ITEM_TEXT_EMPLOYEE_OPERATIONS;
                }

                @Override
                public void menuAction() {
                    employeeActivity();
                }
            } );
            put(MAIN_MENU_ITEM_CODE_COURSE, new MenuItem() {
                @Override
                public String getItemText() {
                    return MAIN_MENU_ITEM_TEXT_COURSE_OPERATIONS;
                }

                @Override
                public void menuAction() {
                    courseActivity();
                }
            });
            put(MAIN_MENU_ITEM_CODE_MENU, new MenuItem() {
                @Override
                public String getItemText() {
                    return MAIN_MENU_ITEM_TEXT_MENU_OPERATIONS;
                }

                @Override
                public void menuAction() {
                    menuActivity();
                }
            });
            put(MAIN_MENU_ITEM_CODE_ORDER, new MenuItem() {
                @Override
                public String getItemText() {
                    return MAIN_MENU_ITEM_TEXT_ORDER_OPERATIONS;
                }

                @Override
                public void menuAction() {
                    orderActivity();
                }
            });
            put(MAIN_MENU_ITEM_CODE_KITCHEN, new MenuItem() {
                @Override
                public String getItemText() {
                    return MAIN_MENU_ITEM_TEXT_KITCHEN_OPERATIONS;
                }

                @Override
                public void menuAction() {
                    kitchenActivity();
                }
            });
            put(MAIN_MENU_ITEM_CODE_WAREHOUSE, new MenuItem() {
                @Override
                public String getItemText() {
                    return MAIN_MENU_ITEM_TEXT_WAREHOUSE_OPERATIONS;
                }

                @Override
                public void menuAction() {
                    warehouseActivity();
                }
            });
            put(MAIN_MENU_ITEM_CODE_EXIT, new MenuItem() {
                @Override
                public String getItemText() {
                    return MENU_ITEM_TEXT_EXIT;
                }

                @Override
                public void menuAction() {
                }
            });
        }
    };

    private static final int EMPLOYEE_MENU_ITEM_CODE_ADD = 1;
    private static final int EMPLOYEE_MENU_ITEM_CODE_DELETE = 2;
    private static final int EMPLOYEE_MENU_ITEM_CODE_FIND = 3;
    private static final int EMPLOYEE_MENU_ITEM_CODE_LIST = 4;
    private static final int EMPLOYEE_MENU_ITEM_CODE_EXIT = 5;
    private static final String EMPLOYEE_MENU_ITEM_TEXT_ADD = "Add employee";
    private static final String EMPLOYEE_MENU_ITEM_TEXT_DELETE = "Delete employee";
    private static final String EMPLOYEE_MENU_ITEM_TEXT_FIND = "Find employee by name";
    private static final String EMPLOYEE_MENU_ITEM_TEXT_LIST = "Get employee list";
    private static final HashMap<Integer, MenuItem> employeeMenuMap = new HashMap<Integer, MenuItem>(){
        {
            put(EMPLOYEE_MENU_ITEM_CODE_ADD, new MenuItemEmployeeAdd(EMPLOYEE_MENU_ITEM_TEXT_ADD));
            put(EMPLOYEE_MENU_ITEM_CODE_DELETE, new MenuItemEmployeeDelete(EMPLOYEE_MENU_ITEM_TEXT_DELETE));
            put(EMPLOYEE_MENU_ITEM_CODE_FIND, new MenuItemEmployeeFind(EMPLOYEE_MENU_ITEM_TEXT_FIND));
            put(EMPLOYEE_MENU_ITEM_CODE_LIST, new MenuItemEmployeeWholeList(EMPLOYEE_MENU_ITEM_TEXT_LIST));
            put(EMPLOYEE_MENU_ITEM_CODE_EXIT, new MenuItemEmptyAction(MENU_ITEM_TEXT_EXIT));
        }
    };

    private static final int COURSE_MENU_ITEM_CODE_ADD = 1;
    private static final int COURSE_MENU_ITEM_CODE_DELETE = 2;
    private static final int COURSE_MENU_ITEM_CODE_FIND = 3;
    private static final int COURSE_MENU_ITEM_CODE_LIST = 4;
    private static final int COURSE_MENU_ITEM_CODE_EXIT = 5;
    private static final String COURSE_MENU_ITEM_TEXT_ADD = "Add course";
    private static final String COURSE_MENU_ITEM_TEXT_DELETE = "Delete course";
    private static final String COURSE_MENU_ITEM_TEXT_FIND = "Find course by name";
    private static final String COURSE_MENU_ITEM_TEXT_LIST = "Get course list";
    private static final HashMap<Integer, MenuItem> courseMenuMap = new HashMap<Integer, MenuItem>(){
        {
            put(COURSE_MENU_ITEM_CODE_ADD, new MenuItemCourseAdd(COURSE_MENU_ITEM_TEXT_ADD));
            put(COURSE_MENU_ITEM_CODE_DELETE, new MenuItemCourseDelete(COURSE_MENU_ITEM_TEXT_DELETE));
            put(COURSE_MENU_ITEM_CODE_FIND, new MenuItemCourseFind(COURSE_MENU_ITEM_TEXT_FIND));
            put(COURSE_MENU_ITEM_CODE_LIST, new MenuItemCourseWholeList(COURSE_MENU_ITEM_TEXT_LIST));
            put(COURSE_MENU_ITEM_CODE_EXIT, new MenuItemEmptyAction(MENU_ITEM_TEXT_EXIT));
        }
    };

    private static final int MENU_MENU_ITEM_CODE_ADD = 1;
    private static final int MENU_MENU_ITEM_CODE_DELETE = 2;
    private static final int MENU_MENU_ITEM_CODE_FIND = 3;
    private static final int MENU_MENU_ITEM_CODE_LIST = 4;
    private static final int MENU_MENU_ITEM_CODE_ADD_COURSE = 5;
    private static final int MENU_MENU_ITEM_CODE_DEL_COURSE = 6;
    private static final int MENU_MENU_ITEM_CODE_EXIT = 7;
    private static final String MENU_MENU_ITEM_TEXT_ADD = "Add menu";
    private static final String MENU_MENU_ITEM_TEXT_DELETE = "Delete menu";
    private static final String MENU_MENU_ITEM_TEXT_FIND = "Find menu by name";
    private static final String MENU_MENU_ITEM_TEXT_LIST = "Get menu list";
    private static final String MENU_MENU_ITEM_TEXT_ADD_COURSE = "Add course to menu";
    private static final String MENU_MENU_ITEM_TEXT_DEL_COURSE = "Delete course from menu";
    private static final HashMap<Integer, MenuItem> menuMenuMap = new HashMap<Integer, MenuItem>(){
        {
            put(MENU_MENU_ITEM_CODE_ADD, new MenuItemEmptyAction(MENU_MENU_ITEM_TEXT_ADD));
            put(MENU_MENU_ITEM_CODE_DELETE, new MenuItemEmptyAction(MENU_MENU_ITEM_TEXT_DELETE));
            put(MENU_MENU_ITEM_CODE_FIND, new MenuItemEmptyAction(MENU_MENU_ITEM_TEXT_FIND));
            put(MENU_MENU_ITEM_CODE_LIST, new MenuItemMenuWholeList(MENU_MENU_ITEM_TEXT_LIST));
            put(MENU_MENU_ITEM_CODE_ADD_COURSE, new MenuItemEmptyAction(MENU_MENU_ITEM_TEXT_ADD_COURSE));
            put(MENU_MENU_ITEM_CODE_DEL_COURSE, new MenuItemEmptyAction(MENU_MENU_ITEM_TEXT_DEL_COURSE));
            put(MENU_MENU_ITEM_CODE_EXIT, new MenuItemEmptyAction(MENU_ITEM_TEXT_EXIT));
        }
    };

    private static final int ORDER_MENU_ITEM_CODE_ADD = 1;
    private static final int ORDER_MENU_ITEM_CODE_DELETE = 2;
    private static final int ORDER_MENU_ITEM_CODE_ADD_COURSE = 3;
    private static final int ORDER_MENU_ITEM_CODE_DEL_COURSE = 4;
    private static final int ORDER_MENU_ITEM_CODE_CLOSE_ORDER = 5;
    private static final int ORDER_MENU_ITEM_CODE_OPEN_ORDER_LIST = 6;
    private static final int ORDER_MENU_ITEM_CODE_CLOSED_ORDER_LIST = 7;
    private static final int ORDER_MENU_ITEM_CODE_EXIT = 8;
    private static final String ORDER_MENU_ITEM_TEXT_ADD = "Add order";
    private static final String ORDER_MENU_ITEM_TEXT_DELETE = "Delete order";
    private static final String ORDER_MENU_ITEM_TEXT_ADD_COURSE = "Add course to order";
    private static final String ORDER_MENU_ITEM_TEXT_DEL_COURSE = "Delete course from order";
    private static final String ORDER_MENU_ITEM_TEXT_CLOSE_ORDER = "Close order";
    private static final String ORDER_MENU_ITEM_TEXT_OPEN_ORDER_LIST = "Open order list";
    private static final String ORDER_MENU_ITEM_TEXT_CLOSED_ORDER_LIST = "Closed order tableList";
    private static final HashMap<Integer, MenuItem> orderMenuMap = new HashMap<Integer, MenuItem>(){
        {
            put(ORDER_MENU_ITEM_CODE_ADD, new MenuItemEmptyAction(ORDER_MENU_ITEM_TEXT_ADD));
            put(ORDER_MENU_ITEM_CODE_DELETE, new MenuItemEmptyAction(ORDER_MENU_ITEM_TEXT_DELETE));
            put(ORDER_MENU_ITEM_CODE_ADD_COURSE, new MenuItemEmptyAction(ORDER_MENU_ITEM_TEXT_ADD_COURSE));
            put(ORDER_MENU_ITEM_CODE_DEL_COURSE, new MenuItemEmptyAction(ORDER_MENU_ITEM_TEXT_DEL_COURSE));
            put(ORDER_MENU_ITEM_CODE_CLOSE_ORDER, new MenuItemEmptyAction(ORDER_MENU_ITEM_TEXT_CLOSE_ORDER));
            put(ORDER_MENU_ITEM_CODE_OPEN_ORDER_LIST, new MenuItemEmptyAction(ORDER_MENU_ITEM_TEXT_OPEN_ORDER_LIST));
            put(ORDER_MENU_ITEM_CODE_CLOSED_ORDER_LIST, new MenuItemEmptyAction(ORDER_MENU_ITEM_TEXT_CLOSED_ORDER_LIST));
            put(ORDER_MENU_ITEM_CODE_EXIT, new MenuItemEmptyAction(MENU_ITEM_TEXT_EXIT));
        }
    };

    private static final int KITCHEN_MENU_ITEM_CODE_ADD_COOKED_COURSE = 1;
    private static final int KITCHEN_MENU_ITEM_CODE_COOKED_COURSE_LIST = 2;
    private static final int KITCHEN_MENU_ITEM_CODE_EXIT = 3;
    private static final String KITCHEN_MENU_ITEM_TEXT_ADD_COOKED_COURSE = "Add cooked course";
    private static final String KITCHEN_MENU_ITEM_TEXT_COOKED_COURSE_LIST = "Get cooked course list";
    private static final HashMap<Integer, MenuItem> kitchenMenuMap = new HashMap<Integer, MenuItem>(){
        {
            put(KITCHEN_MENU_ITEM_CODE_ADD_COOKED_COURSE, new MenuItemEmptyAction(KITCHEN_MENU_ITEM_TEXT_ADD_COOKED_COURSE));
            put(KITCHEN_MENU_ITEM_CODE_COOKED_COURSE_LIST, new MenuItemEmptyAction(KITCHEN_MENU_ITEM_TEXT_COOKED_COURSE_LIST));
            put(KITCHEN_MENU_ITEM_CODE_EXIT, new MenuItemEmptyAction(MENU_ITEM_TEXT_EXIT));
        }
    };

    private static final int WAREHOUSE_MENU_ITEM_CODE_ADD = 1;
    private static final int WAREHOUSE_MENU_ITEM_CODE_DELETE = 2;
    private static final int WAREHOUSE_MENU_ITEM_CODE_FIND = 3;
    private static final int WAREHOUSE_MENU_ITEM_CODE_LIST = 4;
    private static final int WAREHOUSE_MENU_ITEM_CODE_ELAPSING_LIST = 5;
    private static final int WAREHOUSE_MENU_ITEM_CODE_EXIT = 6;
    private static final String WAREHOUSE_MENU_ITEM_TEXT_ADD = "Add ingredient to warehouse";
    private static final String WAREHOUSE_MENU_ITEM_TEXT_DELETE = "Delete ingredient from";
    private static final String WAREHOUSE_MENU_ITEM_TEXT_FIND = "Find ingredient by name";
    private static final String WAREHOUSE_MENU_ITEM_TEXT_LIST = "Get ingredient list";
    private static final String WAREHOUSE_MENU_ITEM_TEXT_ELAPSING_LIST = "Get elapsing ingredient tableList";
    private static final HashMap<Integer, MenuItem> warehouseMenuMap = new HashMap<Integer, MenuItem>(){
        {
            put(WAREHOUSE_MENU_ITEM_CODE_ADD, new MenuItemCourseAdd(WAREHOUSE_MENU_ITEM_TEXT_ADD));
            put(WAREHOUSE_MENU_ITEM_CODE_DELETE, new MenuItemCourseDelete(WAREHOUSE_MENU_ITEM_TEXT_DELETE));
            put(WAREHOUSE_MENU_ITEM_CODE_FIND, new MenuItemCourseFind(WAREHOUSE_MENU_ITEM_TEXT_FIND));
            put(WAREHOUSE_MENU_ITEM_CODE_LIST, new MenuItemEmptyAction(WAREHOUSE_MENU_ITEM_TEXT_LIST));
            put(WAREHOUSE_MENU_ITEM_CODE_ELAPSING_LIST, new MenuItemEmptyAction(WAREHOUSE_MENU_ITEM_TEXT_ELAPSING_LIST));
            put(WAREHOUSE_MENU_ITEM_CODE_EXIT, new MenuItemEmptyAction(MENU_ITEM_TEXT_EXIT));
        }
    };

    private static RestaurantController staticRestaurantController;

    public void setRestaurantController(RestaurantController restaurantController) {
        staticRestaurantController = restaurantController;
    }

    public static RestaurantController getRestaurantController() {
        return staticRestaurantController;
    }

    private int chooseMainMenuItemCode() {
        return Util.chooseMenuItemCode(CHOOSE_ACTIVITY_MESSAGE, mainMenuItemMap, MAIN_MENU_ITEM_CODE_EXIT);
    }

    private void mainMenuProcess() {
        chooseMainMenuItemCode();
    }

    public void run() {
        Util.printMessage(TITLE_MESSAGE);
        mainMenuProcess();
        Util.printMessage(FAREWELL_MESSAGE);
    }

    private static void employeeActivity() {
        Util.chooseMenuItemCode(CHOOSE_ACTIVITY_MESSAGE, employeeMenuMap, EMPLOYEE_MENU_ITEM_CODE_EXIT);
    }

    private static void courseActivity() {
        Util.chooseMenuItemCode(CHOOSE_ACTIVITY_MESSAGE, courseMenuMap, COURSE_MENU_ITEM_CODE_EXIT);
    }

    private static void menuActivity() {
        Util.chooseMenuItemCode(CHOOSE_ACTIVITY_MESSAGE, menuMenuMap, MENU_MENU_ITEM_CODE_EXIT);
    }

    private static void orderActivity() {
        Util.chooseMenuItemCode(CHOOSE_ACTIVITY_MESSAGE, orderMenuMap, ORDER_MENU_ITEM_CODE_EXIT);
    }

    private static void kitchenActivity() {
        Util.chooseMenuItemCode(CHOOSE_ACTIVITY_MESSAGE, kitchenMenuMap, KITCHEN_MENU_ITEM_CODE_EXIT);
    }

    private static void warehouseActivity() {
        Util.chooseMenuItemCode(CHOOSE_ACTIVITY_MESSAGE, warehouseMenuMap, WAREHOUSE_MENU_ITEM_CODE_EXIT);
    }
}
