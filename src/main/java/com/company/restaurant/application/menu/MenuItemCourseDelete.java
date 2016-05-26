package com.company.restaurant.application.menu;

import com.company.restaurant.model.Course;

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
    protected List<Course> showInitialList() {
        return tableList();
    }

    @Override
    protected boolean initialListCanBeEmpty() {
        return false;
    }

    @Override
    protected String doActionOnDatabaseObject(Course course) {
        return getRestaurantController().delCourse(course);
    }

    @Override
    protected void actionHasBeenSuccessfullyPerformedMessage() {
        super.dataHasBeenSuccessfullyDeletedMessage();
    }
}
