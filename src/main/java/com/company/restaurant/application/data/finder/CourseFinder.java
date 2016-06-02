package com.company.restaurant.application.data.finder;

import com.company.restaurant.model.Course;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class CourseFinder extends ObjectOneRecordFinderProto<Course, String> {
    private static final String ENTER_NAME_MESSAGE = "Please, enter course name";

    @Override
    protected Course findObject(String courseName) {
        return getRestaurantController().findCourseByName(courseName);
    }

    @Override
    protected String readKeyFieldValue() {
        return readStringKeyFieldValue();
    }

    @Override
    protected String getEnterNameMessage() {
        return ENTER_NAME_MESSAGE;
    }
}
