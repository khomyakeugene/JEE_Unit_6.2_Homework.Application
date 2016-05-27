package com.company.restaurant.application.menu;

import com.company.util.Util;

/**
 * Created by Yevhen on 28.05.2016.
 */
public abstract class MenuItemCourse extends DatabaseMenuItem implements MenuItem {
    private static final String ENTER_NAME_MESSAGE = "Please, enter course name";

    public MenuItemCourse(String itemText) {
        super(itemText);
    }

    protected String readCourseName() {
        return Util.readInputString(ENTER_NAME_MESSAGE, false);
    }
}
