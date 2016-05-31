package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.remover.CourseRemover;
import com.company.restaurant.application.data.remover.ObjectRemover;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;
import com.company.restaurant.model.Course;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseDelete extends SafeMenuItem implements MenuItem {
    private ObjectRemover<Course> courseRemover = CourseRemover.newInstance();

    @Override
    protected void performAction() {
        courseRemover.deleteObjects();
    }
}
