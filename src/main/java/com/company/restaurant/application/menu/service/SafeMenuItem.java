package com.company.restaurant.application.menu.service;

/**
 * Created by Yevhen on 27.05.2016.
 */
public abstract class SafeMenuItem extends SimpleMenuItem implements MenuItem {
    public SafeMenuItem(String itemText) {
        super(itemText);
    }

    protected abstract void performAction();

    @Override
    public void menuAction() {
        try {
            performAction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
