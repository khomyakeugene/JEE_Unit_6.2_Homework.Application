package com.company.restaurant.application.data;

import com.company.restaurant.application.data.service.ObjectChooser;
import com.company.restaurant.model.CourseCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class CourseCategoryChooser extends ObjectChooser<CourseCategory, Integer> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter course category identifier";
    private static final String[] listHeader = new String[] {
            "Course Id",
            "Course name"
    };

    @Override
    protected CourseCategory findObject(Integer courseCategoryId) {
        return getRestaurantController().findCourseCategoryById(courseCategoryId);
    }

    @Override
    protected Integer readObjectKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }

    @Override
    protected List<CourseCategory> prepareObjectList() {
        return getRestaurantController().findAllCourseCategories();
    }

    @Override
    protected String[] getListHeader() {
        return listHeader;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(CourseCategory courseCategory) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(courseCategory.getId()));
        arrayList.add(courseCategory.getName());

        return arrayList.toArray(new String[arrayList.size()]);
    }

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }
}
