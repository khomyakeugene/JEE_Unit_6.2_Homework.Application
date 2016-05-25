package com.company.restaurant.application.menu;

import com.company.restaurant.model.CourseCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class CourseCategoryList extends SimpleDicFunctionality<CourseCategory> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter course category identifier";

    @Override
    protected CourseCategory findOneObject() {
        return null;
    }

    @Override
    protected List<CourseCategory> findData() {
        return getRestaurantController().findAllCourseCategories();
    }

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }

    @Override
    protected boolean validateId(Integer Id) {
        return (getRestaurantController().findCourseCategoryById(Id) != null);
    }
}
