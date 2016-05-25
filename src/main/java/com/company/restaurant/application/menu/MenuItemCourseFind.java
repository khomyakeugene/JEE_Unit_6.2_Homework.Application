package com.company.restaurant.application.menu;

import com.company.restaurant.model.Course;
import com.company.util.Util;

import java.util.List;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseFind extends MenuItemCourseList implements MenuItem {
    private static final String ENTER_NAME_MESSAGE = "Please, enter course name (or just enter to finish)";

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

    public String readCourseName() {
        courseName = Util.readInputString(ENTER_NAME_MESSAGE).trim();

        return courseName;
    }

    private void findCourseByName() {
        readCourseName();
        tableList();
    }
}
