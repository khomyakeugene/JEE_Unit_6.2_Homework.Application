package com.company.restaurant.application.menu;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseAdd extends DatabaseMenuItem implements MenuItem {
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
