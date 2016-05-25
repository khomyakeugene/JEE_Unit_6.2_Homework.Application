package com.company.restaurant.application.menu;

import com.company.restaurant.model.Course;
import com.company.util.MenuItem;
import com.company.util.Util;

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

    protected String readCourseName() {
        courseName = Util.readInputString(ENTER_NAME_MESSAGE);

        return courseName;
    }

    private void findCourseByName() {
        readCourseName();
        tableList();
    }
}
