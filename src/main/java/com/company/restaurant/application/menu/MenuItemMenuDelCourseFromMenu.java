package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.MenuCourseCollector;
import com.company.restaurant.application.data.chooser.MenuChooser;
import com.company.restaurant.application.data.chooser.MenuCourseChooser;
import com.company.restaurant.application.data.list.CourseTableList;
import com.company.restaurant.application.data.list.MenuTableList;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuDelCourseFromMenu extends DatabaseMenuItem implements MenuItem {
    private MenuCourseCollector menuCourseCollector =
            new MenuCourseCollector(new MenuChooser(new MenuTableList()),
            new MenuCourseChooser(new CourseTableList()));

    public MenuItemMenuDelCourseFromMenu(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {

    }
}
