package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.MenuCourseCollector;
import com.company.restaurant.application.data.chooser.CourseChooser;
import com.company.restaurant.application.data.chooser.MenuChooser;
import com.company.restaurant.application.data.list.CourseTableList;
import com.company.restaurant.application.data.list.MenuTableList;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuAddCourseToMenu extends SafeMenuItem implements MenuItem {
    public MenuItemMenuAddCourseToMenu(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        new MenuCourseCollector(new MenuChooser(new MenuTableList()),
                new CourseChooser(new CourseTableList())).addItemsToObject();
    }
}

