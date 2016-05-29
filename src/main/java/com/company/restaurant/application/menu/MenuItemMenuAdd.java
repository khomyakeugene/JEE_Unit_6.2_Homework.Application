package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.collector.ItemCollector;
import com.company.restaurant.application.data.collector.MenuCourseCollector;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.model.Menu;
import com.company.util.Util;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuAdd extends DatabaseMenuItem implements MenuItem {
    private static final String ENTER_NAME_MESSAGE = "Please, enter menu name";

    private ItemCollector<Menu> menuCourseCollector = MenuCourseCollector.newInstance();

    public MenuItemMenuAdd(String itemText) {
        super(itemText);
    }

    private Menu addMenu() {
        Menu result = null;

        String menuName = Util.readInputString(ENTER_NAME_MESSAGE);
        if (menuName != null && !menuName.isEmpty()) {
            result = getRestaurantController().addMenu(menuName.trim());
            dataHasBeenSuccessfullyAddedMessage();
        }

        return result;
    }

    @Override
    protected void performAction() {
        menuCourseCollector.addItemsToObject(addMenu());
    }
}
