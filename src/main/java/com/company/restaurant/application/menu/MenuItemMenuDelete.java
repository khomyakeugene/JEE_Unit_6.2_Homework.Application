package com.company.restaurant.application.menu;

import com.company.restaurant.model.Menu;

import java.util.List;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuDelete extends MenuItemMenuFind implements MenuItem {
    public MenuItemMenuDelete(String itemText) {
        super(itemText);
    }

    @Override
    protected List<Menu> findData() {
        return getRestaurantController().findAllMenus();
    }

    @Override
    protected void readObjectKeyData() {
        readMenuName();
    }

    @Override
    protected String doActionOnDatabaseObject(Menu menu) {
        return getRestaurantController().delMenu(menu.getName());
    }

    @Override
    protected void actionHasBeenSuccessfullyPerformedMessage() {
        super.dataHasBeenSuccessfullyDeletedMessage();
    }
}
