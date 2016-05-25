package com.company.restaurant.application;

import com.company.restaurant.model.Course;
import com.company.util.MenuItem;
import com.company.util.Util;

import java.util.List;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseFind extends MenuItemCourseList implements MenuItem {
    private static final String ENTER_NAME_MESSAGE = "Please, enter course name";

    private String courseName;

    public MenuItemCourseFind(String itemText) {
        super(itemText);
    }

    @Override
    protected Course findOneObject() {
        return getRestaurantController().findCourseByName(courseName);
    }

    @Override
    public void menuAction() {
        findCourseByName();
    }

    private void findCourseByName() {
        courseName = Util.readInputString(ENTER_NAME_MESSAGE);

        tableList();
    }
}
