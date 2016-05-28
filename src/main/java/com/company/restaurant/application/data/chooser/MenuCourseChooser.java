package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.service.ItemChooser;
import com.company.restaurant.application.data.service.ObjectTableList;
import com.company.restaurant.model.Course;
import com.company.restaurant.model.Menu;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class MenuCourseChooser extends CourseChooser implements ItemChooser<Menu, Course> {
    public MenuCourseChooser(ObjectTableList<Course> objectTableList) {
        super(objectTableList);
    }

    @Override
    public Course chooseObjectFromList(Menu object) {
        return null;
    }
}
