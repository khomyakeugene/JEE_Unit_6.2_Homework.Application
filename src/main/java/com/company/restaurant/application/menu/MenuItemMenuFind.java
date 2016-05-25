package com.company.restaurant.application.menu;

import com.company.restaurant.model.Menu;
import com.company.util.Util;

import java.util.List;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuFind extends MenuItemMenuList implements MenuItem {
    private static final String ENTER_NAME_MESSAGE = "Please, enter menu name";

    protected String menuName;

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
    public void menuAction() {
        findMenuByName();
    }

    private void findMenuByName() {
        readMenuName();
        tableList();
    }
}
