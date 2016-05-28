package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.finder.CourseFinder;
import com.company.restaurant.application.data.list.CourseTableList;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseFind extends DatabaseMenuItem implements MenuItem {
    public MenuItemCourseFind(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        new CourseFinder(new CourseTableList()).findAndDisplayObjectList();
    }
}
