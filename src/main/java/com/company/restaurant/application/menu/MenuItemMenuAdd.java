package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.adder.ObjectAdder;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;
import com.company.restaurant.model.Menu;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuAdd extends SafeMenuItem implements MenuItem {
    private ObjectAdder<Menu> menuAdder;

    public void setMenuAdder(ObjectAdder<Menu> menuAdder) {
        this.menuAdder = menuAdder;
    }

    @Override
    protected void performAction() {
        menuAdder.addObjects();
    }
}
