package com.company.restaurant.application.menu;

import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuDelCourseFromMenu extends MenuItemMenuCourse implements MenuItem {
    @Override
    protected void performAction() {
        menuCourseCollector.delItemsFromObject();
    }
}
