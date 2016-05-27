package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.list.CourseTableList;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseWholeList extends DatabaseMenuItem implements MenuItem {
    public MenuItemCourseWholeList(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        new CourseTableList().displayObjectList();
    }
}
