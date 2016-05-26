package com.company.restaurant.application.menu;

import com.company.restaurant.model.Menu;

import java.util.List;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuWholeList extends MenuItemMenuList implements MenuItem {
    public MenuItemMenuWholeList(String itemText) {
        super(itemText);
    }

    @Override
    protected Menu findOneObject() {
        return null;
    }

    @Override
    protected List<Menu> findData() {
        return getRestaurantController().findAllMenus();
    }

    @Override
    protected void executeAction() {
        menuList();
    }

    private void menuList() {
        tableList();
    }
}
