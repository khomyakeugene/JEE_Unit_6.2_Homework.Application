package com.company.restaurant.application;

import com.company.util.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseAdd extends SimpleMenuItem implements MenuItem {
    public MenuItemCourseAdd(String itemText) {
        super(itemText);
    }

    @Override
    public void menuAction() {
        addCourse();
    }

    private void addCourse() {

    }
}
