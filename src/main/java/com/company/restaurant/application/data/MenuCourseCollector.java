package com.company.restaurant.application.data;

import com.company.restaurant.application.data.service.ItemChooser;
import com.company.restaurant.application.data.service.ItemCollectorProto;
import com.company.restaurant.application.data.service.ObjectChooser;
import com.company.restaurant.model.Course;
import com.company.restaurant.model.Menu;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class MenuCourseCollector extends ItemCollectorProto<Menu, Course> {
    public MenuCourseCollector(ObjectChooser<Menu> objectChooser, ItemChooser<Menu, Course> itemChooser) {
        super(objectChooser, itemChooser);
    }

    @Override
    protected void addItemToObject(Menu menu, Course course) {
        getRestaurantController().addCourseToMenu(menu, course);
    }
}
