package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.list.OpenOrderTableList;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderOpenOrderList extends SafeMenuItem implements MenuItem {
    private OpenOrderTableList openOrderTableList;

    public void setOpenOrderTableList(OpenOrderTableList openOrderTableList) {
        this.openOrderTableList = openOrderTableList;
    }

    @Override
    protected void performAction() {
        openOrderTableList.displayObjectList();
    }
}
