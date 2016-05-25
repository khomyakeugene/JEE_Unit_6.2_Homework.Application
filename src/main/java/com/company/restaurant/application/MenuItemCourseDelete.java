package com.company.restaurant.application;

import com.company.util.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseDelete extends SimpleMenuItem implements MenuItem {
    public MenuItemCourseDelete(String itemText) {
        super(itemText);
    }

    @Override
    public void menuAction() {
        deleteCourse();
    }

    private void deleteCourse() {

    }
}
