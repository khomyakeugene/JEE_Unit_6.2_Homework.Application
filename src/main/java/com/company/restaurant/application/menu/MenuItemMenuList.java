package com.company.restaurant.application.menu;

import com.company.restaurant.model.Menu;
import com.company.util.MenuItem;

import java.util.ArrayList;

/**
 * Created by Yevhen on 25.05.2016.
 */
public abstract class MenuItemMenuList extends MenuItemList<Menu> implements MenuItem {
    private static final String[] menuListHeader = new String[] {
            "Menu Id",
            "Menu name"
    };

    public MenuItemMenuList(String itemText) {
        super(itemText);
    }

    @Override
    protected String[] getListHeader() {
        return menuListHeader;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(Menu menu) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(menu.getId()));
        arrayList.add(menu.getName());

        return arrayList.toArray(new String[arrayList.size()]);
    }
}
