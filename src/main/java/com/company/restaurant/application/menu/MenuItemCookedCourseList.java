package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.list.CookedCourseTableList;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class MenuItemCookedCourseList extends SafeMenuItem implements MenuItem {
    private CookedCourseTableList cookedCourseTableList = new CookedCourseTableList();

    @Override
    protected void performAction() {
        cookedCourseTableList.displayObjectList();
    }
}
