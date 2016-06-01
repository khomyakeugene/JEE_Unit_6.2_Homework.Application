package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.finder.CourseFinder;
import com.company.restaurant.application.data.finder.ObjectFinder;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;
import com.company.restaurant.model.Course;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseFind extends SafeMenuItem implements MenuItem {
    private ObjectFinder<Course> courseFinder;

    public void setCourseFinder(ObjectFinder<Course> courseFinder) {
        this.courseFinder = courseFinder;
    }

    @Override
    protected void performAction() {
        courseFinder.findAndDisplayObjectList();
    }
}
