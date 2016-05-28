package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.chooser.MenuChooser;
import com.company.restaurant.application.data.list.MenuTableList;
import com.company.restaurant.application.data.remover.MenuRemover;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuDelete extends DatabaseMenuItem implements MenuItem {
    public MenuItemMenuDelete(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        new MenuRemover(new MenuChooser(new MenuTableList())).deleteObject();
    }
}
