package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.finder.MenuFinder;
import com.company.restaurant.application.data.list.MenuTableList;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuFind extends SafeMenuItem implements MenuItem {
    private MenuFinder menuFinder = new MenuFinder(new MenuTableList());

    public MenuItemMenuFind(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        menuFinder.findAndDisplayObjectList();
    }
}
