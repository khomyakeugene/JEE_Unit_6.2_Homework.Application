package com.company.restaurant.application.data.remover;

import com.company.restaurant.application.data.service.ObjectChooser;
import com.company.restaurant.application.data.service.ObjectRemoverProto;
import com.company.restaurant.model.Course;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class CourseRemover extends ObjectRemoverProto<Course> {
    public CourseRemover(ObjectChooser<Course> objectChooser) {
        super(objectChooser);
    }

    @Override
    protected String delObject(Course course) {
        return getRestaurantController().delCourse(course);
    }
}
