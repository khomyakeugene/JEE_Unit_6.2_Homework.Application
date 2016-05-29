package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.adder.MenuAdder;
import com.company.restaurant.application.data.adder.ObjectAdder;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.model.Menu;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuAdd extends DatabaseMenuItem implements MenuItem {
    private ObjectAdder<Menu> menuAdder = MenuAdder.newInstance();

    public MenuItemMenuAdd(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        menuAdder.addObjects();
    }
}
