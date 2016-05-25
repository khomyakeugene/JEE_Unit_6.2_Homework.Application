package com.company.restaurant.application.menu;

import com.company.util.DataIntegrityException;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuAdd extends MenuItemMenuFind implements MenuItem {
    public MenuItemMenuAdd(String itemText) {
        super(itemText);
    }

    @Override
    public void menuAction() {
        addMenu();
    }

    private void addMenu() {
        readMenuName();
        if (menuName != null && !menuName.isEmpty()) {
            getRestaurantController().addMenu(menuName);
            dataHasBeenSuccessfullyAddedMessage();
        }
    }
}
