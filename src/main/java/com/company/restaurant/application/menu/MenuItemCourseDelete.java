package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.chooser.CourseChooser;
import com.company.restaurant.application.data.list.CourseTableList;
import com.company.restaurant.application.data.remover.CourseRemover;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseDelete extends DatabaseMenuItem implements MenuItem {
    public MenuItemCourseDelete(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        new CourseRemover(new CourseChooser(new CourseTableList())).deleteObject();
    }
}
