package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.remover.MenuRemover;
import com.company.restaurant.application.data.remover.ObjectRemover;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.model.Menu;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuDelete extends DatabaseMenuItem implements MenuItem {
    private ObjectRemover<Menu> menuRemover = MenuRemover.newInstance();

    public MenuItemMenuDelete(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        menuRemover.deleteObject();
    }
}
