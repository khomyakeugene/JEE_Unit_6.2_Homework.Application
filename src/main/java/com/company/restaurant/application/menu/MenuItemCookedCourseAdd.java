package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.adder.CookedCourseAdder;
import com.company.restaurant.application.data.adder.ObjectAdderProto;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;
import com.company.restaurant.model.CookedCourse;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class MenuItemCookedCourseAdd extends SafeMenuItem implements MenuItem {
    ObjectAdderProto<CookedCourse> cookedCourseAdder = CookedCourseAdder.newInstance();

    public MenuItemCookedCourseAdd(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        cookedCourseAdder.addObjects();
    }
}
