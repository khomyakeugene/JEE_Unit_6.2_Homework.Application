package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.chooser.CourseChooser;
import com.company.restaurant.application.data.chooser.OrderChooser;
import com.company.restaurant.application.data.chooser.OrderCourseChooser;
import com.company.restaurant.application.data.collector.OrderCourseCollector;
import com.company.restaurant.application.data.list.CourseTableList;
import com.company.restaurant.application.data.list.OpenOrderTableList;
import com.company.restaurant.application.data.list.OrderCourseTableList;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;

/**
 * Created by Yevhen on 29.05.2016.
 */
public abstract class MenuItemOrderCourse extends SafeMenuItem implements MenuItem {
    protected OrderCourseCollector orderCourseCollector = new OrderCourseCollector(
            new OrderChooser(new OpenOrderTableList()),
            new CourseChooser(new CourseTableList()),
            new OrderCourseChooser(new OrderCourseTableList()));

    public MenuItemOrderCourse(String itemText) {
        super(itemText);
    }
}
