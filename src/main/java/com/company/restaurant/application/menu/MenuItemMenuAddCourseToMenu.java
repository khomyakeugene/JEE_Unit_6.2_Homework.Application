package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.*;
import com.company.restaurant.application.data.chooser.CourseChooser;
import com.company.restaurant.application.data.chooser.MenuChooser;
import com.company.restaurant.application.data.list.CourseTableList;
import com.company.restaurant.application.data.list.MenuTableList;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuAddCourseToMenu extends SafeMenuItem implements MenuItem {
    public MenuItemMenuAddCourseToMenu(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        new CourseToMenuAdder(new MenuChooser(new MenuTableList()),
                new CourseChooser(new CourseTableList())).addItemsToObject();
    }
}

