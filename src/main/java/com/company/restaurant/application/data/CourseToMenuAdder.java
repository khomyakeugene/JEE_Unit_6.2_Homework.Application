package com.company.restaurant.application.data;

import com.company.restaurant.application.data.service.ItemAdderProto;
import com.company.restaurant.application.data.service.ObjectChooser;
import com.company.restaurant.model.Course;
import com.company.restaurant.model.Menu;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class CourseToMenuAdder extends ItemAdderProto<Menu, Course> {
    public CourseToMenuAdder(ObjectChooser<Menu> objectChooser, ObjectChooser<Course> itemChooser) {
        super(objectChooser, itemChooser);
    }

    @Override
    protected void addItemToObject(Menu menu, Course course) {
        getRestaurantController().addCourseToMenu(menu, course);
    }
}
