package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.list.CourseCategoryTableList;
import com.company.restaurant.model.CourseCategory;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class CourseCategoryChooser extends ObjectChooserProto<CourseCategory, Integer> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter course category identifier";

    @Override
    protected CourseCategory findObject(Integer courseCategoryId) {
        return getRestaurantController().findCourseCategoryById(courseCategoryId);
    }

    @Override
    protected Integer readKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }

    public static ObjectChooser<CourseCategory> newInstance() {
        CourseCategoryChooser courseCategoryChooser = new CourseCategoryChooser();
        courseCategoryChooser.setObjectTableList(new CourseCategoryTableList());

        return courseCategoryChooser;
    }
}
