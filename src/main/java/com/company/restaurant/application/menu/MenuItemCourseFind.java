package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.finder.ObjectFinder;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;
import com.company.restaurant.model.Course;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseFind extends SafeMenuItem implements MenuItem {
    private ObjectFinder<Course> objectFinder;

    public void setObjectFinder(ObjectFinder<Course> objectFinder) {
        this.objectFinder = objectFinder;
    }

    @Override
    protected void performAction() {
        objectFinder.findAndDisplayObjectList();
    }
}
