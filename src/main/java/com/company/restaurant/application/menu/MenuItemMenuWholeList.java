package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.list.MenuTableList;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuWholeList extends DatabaseMenuItem implements MenuItem {
    public MenuItemMenuWholeList(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        new MenuTableList().displayObjectList();
    }
}
