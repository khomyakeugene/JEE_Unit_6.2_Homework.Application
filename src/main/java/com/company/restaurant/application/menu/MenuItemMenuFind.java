package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.finder.ObjectFinder;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;
import com.company.restaurant.model.Menu;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuFind extends SafeMenuItem implements MenuItem {
    private ObjectFinder<Menu> menuFinder;

    public void setMenuFinder(ObjectFinder<Menu> menuFinder) {
        this.menuFinder = menuFinder;
    }

    @Override
    protected void performAction() {
        menuFinder.findAndDisplayObjectList();
    }
}
