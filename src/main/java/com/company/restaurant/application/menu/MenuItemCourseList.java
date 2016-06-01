package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.list.CourseTableList;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseList extends SafeMenuItem implements MenuItem {
    private CourseTableList courseTableList;

    public void setCourseTableList(CourseTableList courseTableList) {
        this.courseTableList = courseTableList;
    }

    @Override
    protected void performAction() {
        courseTableList.displayObjectList();
    }
}
