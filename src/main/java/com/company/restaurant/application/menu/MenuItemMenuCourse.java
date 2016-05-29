package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.collector.MenuCourseCollector;
import com.company.restaurant.application.data.service.ItemCollector;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;
import com.company.restaurant.model.Menu;

/**
 * Created by Yevhen on 29.05.2016.
 */
public abstract class MenuItemMenuCourse extends SafeMenuItem implements MenuItem {
    protected ItemCollector<Menu> menuCourseCollector = MenuCourseCollector.newInstance();

    public MenuItemMenuCourse(String itemText) {
        super(itemText);
    }
}
