package com.company.restaurant.application.data.remover;

import com.company.restaurant.model.Course;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class CourseRemover extends ObjectRemoverProto<Course> {
    @Override
    protected String deleteObject(Course course) {
        return getRestaurantController().delCourse(course);
    }
}
