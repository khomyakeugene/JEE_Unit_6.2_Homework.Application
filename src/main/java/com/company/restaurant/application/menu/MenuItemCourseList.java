package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.list.CourseTableList;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseList extends DatabaseMenuItem implements MenuItem {
    public MenuItemCourseList(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        new CourseTableList().displayObjectList();
    }
}
