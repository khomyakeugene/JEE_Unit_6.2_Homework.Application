package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.chooser.CourseChooser;
import com.company.restaurant.application.data.chooser.MenuChooser;
import com.company.restaurant.application.data.chooser.MenuCourseChooser;
import com.company.restaurant.application.data.collector.MenuCourseCollector;
import com.company.restaurant.application.data.list.CourseTableList;
import com.company.restaurant.application.data.list.MenuCourseTableList;
import com.company.restaurant.application.data.list.MenuTableList;
import com.company.restaurant.application.data.service.ItemCollector;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;

/**
 * Created by Yevhen on 29.05.2016.
 */
public abstract class MenuItemMenuCourse extends SafeMenuItem implements MenuItem {
    protected ItemCollector menuCourseCollector =
            new MenuCourseCollector(new MenuChooser(new MenuTableList()),
                    new CourseChooser(new CourseTableList()),
                    new MenuCourseChooser(new MenuCourseTableList()));

    public MenuItemMenuCourse(String itemText) {
        super(itemText);
    }
}
