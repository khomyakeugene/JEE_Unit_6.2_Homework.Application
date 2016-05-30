package com.company.restaurant.application.data.remover;

import com.company.restaurant.application.data.chooser.CourseChooser;
import com.company.restaurant.application.data.chooser.ObjectChooser;
import com.company.restaurant.model.Course;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class CourseRemover extends ObjectRemoverProto<Course>  implements ObjectRemover<Course>  {
    private CourseRemover(ObjectChooser<Course> objectChooser) {
        super(objectChooser);
    }

    @Override
    protected String delObject(Course course) {
        return getRestaurantController().delCourse(course);
    }

    public static ObjectRemover<Course> newInstance() {
        return new CourseRemover(CourseChooser.newInstance());
    }
}
