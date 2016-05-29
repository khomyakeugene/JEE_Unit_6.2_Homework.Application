package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.list.ObjectTableList;
import com.company.restaurant.model.CourseCategory;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class CourseCategoryChooser extends ObjectChooserProto<CourseCategory, Integer> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter course category identifier";

    public CourseCategoryChooser(ObjectTableList<CourseCategory> objectTableList) {
        super(objectTableList);
    }

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
}
