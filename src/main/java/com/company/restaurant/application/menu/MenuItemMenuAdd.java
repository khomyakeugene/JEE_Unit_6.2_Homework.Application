package com.company.restaurant.application.menu;

import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.util.Util;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuAdd extends DatabaseMenuItem implements MenuItem {
    private static final String ENTER_NAME_MESSAGE = "Please, enter menu name";

    public MenuItemMenuAdd(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        String menuName = Util.readInputString(ENTER_NAME_MESSAGE);
        if (menuName != null && !menuName.isEmpty()) {
            getRestaurantController().addMenu(menuName.trim());
            dataHasBeenSuccessfullyAddedMessage();
        }
    }
}
