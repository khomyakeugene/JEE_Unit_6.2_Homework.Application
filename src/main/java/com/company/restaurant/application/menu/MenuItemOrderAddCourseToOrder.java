package com.company.restaurant.application.menu;

import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class MenuItemOrderAddCourseToOrder extends MenuItemOrderCourse implements MenuItem {
    @Override
    protected void performAction() {
        orderCourseCollector.addItemsToObject();
    }
}
