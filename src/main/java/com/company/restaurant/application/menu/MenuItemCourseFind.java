package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.finder.CourseFinder;
import com.company.restaurant.application.data.list.CourseTableList;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseFind extends SafeMenuItem implements MenuItem {
    private CourseFinder courseFinder = new CourseFinder(new CourseTableList());

    public MenuItemCourseFind(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        courseFinder.findAndDisplayObjectList();
    }
}
