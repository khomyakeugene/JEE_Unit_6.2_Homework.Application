package com.company.restaurant.application.menu.service;

/**
 * Created by Yevhen on 27.05.2016.
 */
public abstract class SafeMenuItem extends SimpleMenuItem implements MenuItem {
    protected abstract void performAction();

    @Override
    public boolean menuAction() {
        try {
            performAction();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}
