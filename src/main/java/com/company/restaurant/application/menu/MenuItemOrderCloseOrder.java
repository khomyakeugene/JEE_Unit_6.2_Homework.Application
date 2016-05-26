package com.company.restaurant.application.menu;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderCloseOrder extends MenuItemOrderOpenOrderList implements MenuItem {
    public MenuItemOrderCloseOrder(String itemText) {
        super(itemText);
    }

    @Override
    public void menuAction() {
        closeOrder();
    }

    private void closeOrder() {


    }
}
