package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.list.MenuTableList;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuList extends SafeMenuItem implements MenuItem {
    private MenuTableList menuTableList;

    public void setMenuTableList(MenuTableList menuTableList) {
        this.menuTableList = menuTableList;
    }

    @Override
    protected void performAction() {
        menuTableList.displayObjectList();
    }
}
