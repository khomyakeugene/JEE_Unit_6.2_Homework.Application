package com.company.restaurant.application.menu;

import com.company.restaurant.model.Course;

import java.util.List;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseWholeList extends MenuItemCourseList implements MenuItem {
    public MenuItemCourseWholeList(String itemText) {
        super(itemText);
    }

    @Override
    protected Course findOneObject() {
        return null;
    }

    @Override
    protected List<Course> findData() {
        return getRestaurantController().findAllCourses();
    }

    @Override
    protected void executeAction() {
        courseList();
    }

    private void courseList() {
        tableList();
    }
}
