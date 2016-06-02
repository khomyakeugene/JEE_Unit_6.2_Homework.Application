package com.company.restaurant.application.menu.service;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class SafeMenuItem extends SimpleMenuItem implements MenuItem {
    private Executor executor;

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    protected void performAction() {
        executor.execute();
    }

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
