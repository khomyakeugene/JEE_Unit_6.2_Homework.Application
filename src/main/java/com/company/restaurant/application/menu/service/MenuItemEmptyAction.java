package com.company.restaurant.application.menu.service;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemEmptyAction extends SimpleMenuItem implements MenuItem {
    public MenuItemEmptyAction(String itemText) {
        super(itemText);
    }

    @Override
    public void menuAction() {

    }
}
