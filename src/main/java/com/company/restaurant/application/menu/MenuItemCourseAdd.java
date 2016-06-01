package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.adder.ObjectAdder;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;
import com.company.restaurant.model.Course;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseAdd extends SafeMenuItem implements MenuItem {
    private ObjectAdder<Course> courseAdder;

    public void setCourseAdder(ObjectAdder<Course> courseAdder) {
        this.courseAdder = courseAdder;
    }

    @Override
    protected void performAction() {
        courseAdder.addObjects();
    }
}
