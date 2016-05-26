package com.company.restaurant.application.menu;

import com.company.restaurant.model.Course;
import com.company.restaurant.model.Menu;
import com.company.util.Util;

import java.util.List;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseDelete extends MenuItemCourseFind implements MenuItem {
    public MenuItemCourseDelete(String itemText) {
        super(itemText);
    }

    @Override
    protected List<Course> findData() {
        return getRestaurantController().findAllCourses();
    }

    @Override
    protected Course readDeletingItemKeyData() {
        readCourseName();

        return null;
    }

    @Override
    protected String deleteObjectFromDatabase(Course course) {
        return getRestaurantController().delCourse(course);
    }

    @Override
    public void menuAction() {
        deleteObject();
    }
}
