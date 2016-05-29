package com.company.restaurant.application.data.collector;

import com.company.restaurant.application.data.service.ItemChooser;
import com.company.restaurant.application.data.service.ItemCollectorProto;
import com.company.restaurant.application.data.service.ObjectChooser;
import com.company.restaurant.model.Course;
import com.company.restaurant.model.Menu;
import com.company.restaurant.model.MenuCourseList;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class MenuCourseCollector extends ItemCollectorProto<Menu, Course, MenuCourseList> {

    public MenuCourseCollector(ObjectChooser<Menu> objectChooser,
                               ObjectChooser<Course> newItemChooser,
                               ItemChooser<Menu, MenuCourseList> presentItemChooser) {
        super(objectChooser, newItemChooser, presentItemChooser);
    }

    @Override
    protected void addItemToObject(Menu menu, Course course) {
        getRestaurantController().addCourseToMenu(menu, course);
    }
}
