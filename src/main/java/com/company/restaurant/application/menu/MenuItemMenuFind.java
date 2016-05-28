package com.company.restaurant.application.menu;

import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.model.Menu;
import com.company.util.Util;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuFind extends MenuItemMenuList implements MenuItem {
    private static final String ENTER_NAME_MESSAGE = "Please, enter menu name";

    private String menuName;

    public MenuItemMenuFind(String itemText) {
        super(itemText);
    }

    protected String readMenuName() {
        menuName = Util.readInputString(ENTER_NAME_MESSAGE).trim();

        return menuName;
    }

    @Override
    protected Menu findOneObject() {
        return getRestaurantController().findMenuByName(menuName);
    }

    @Override
    protected void executeAction() {
        findMenuByName();
    }

    private void findMenuByName() {
        readMenuName();
        tableList();
    }
}
