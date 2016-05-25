package com.company.restaurant.application;

import com.company.util.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseList extends SimpleMenuItem implements MenuItem {
    public MenuItemCourseList(String itemText) {
        super(itemText);
    }

    @Override
    public void menuAction() {
        courseList();
    }

    private void courseList() {

    }
}
