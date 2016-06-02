package com.company.restaurant.application.data.chooser;

import com.company.restaurant.model.Course;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class CourseChooser extends ObjectChooserProto<Course, Integer>
        implements ObjectChooser<Course> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter course identifier";

    @Override
    protected Course findObject(Integer courseId) {
        return getRestaurantController().findCourseById(courseId);
    }

    @Override
    protected Integer readKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }

}
