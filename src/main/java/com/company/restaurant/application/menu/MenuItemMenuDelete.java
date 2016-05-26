package com.company.restaurant.application.menu;

import com.company.restaurant.model.Menu;
import com.company.restaurant.model.Order;
import com.company.util.Util;

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
    protected Menu readDeletingItemKeyData() {
        readMenuName();

        return null;
    }

    @Override
    protected String deleteObjectFromDatabase(Menu menu) {
        return getRestaurantController().delMenu(menu.getName());
    }

    @Override
    public void menuAction() {
        deleteObject();
    }
}
