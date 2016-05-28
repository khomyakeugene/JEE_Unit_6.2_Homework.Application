package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.list.MenuTableList;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuList extends DatabaseMenuItem implements MenuItem {
    private MenuTableList menuTableList = new MenuTableList();

    public MenuItemMenuList(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        menuTableList.displayObjectList();
    }
}
