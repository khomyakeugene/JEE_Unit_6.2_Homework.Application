package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.list.ClosedOrderTableList;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderClosedOrderList extends SafeMenuItem implements MenuItem {
    private ClosedOrderTableList closedOrderTableList;

    public void setClosedOrderTableList(ClosedOrderTableList closedOrderTableList) {
        this.closedOrderTableList = closedOrderTableList;
    }

    @Override
    protected void performAction() {
        closedOrderTableList.displayObjectList();
    }
}
