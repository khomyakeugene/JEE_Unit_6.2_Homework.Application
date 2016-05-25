package com.company.restaurant.application.menu;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemOrderList extends DatabaseMenuItem implements MenuItem {
    public MenuItemOrderList(String itemText) {
        super(itemText);
    }

    @Override
    protected String[] getListHeader() {
        return new String[0];
    }

    @Override
    protected Object findOneObject() {
        return null;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(Object dataSetRow) {
        return new String[0];
    }

    @Override
    public void menuAction() {

    }
}
