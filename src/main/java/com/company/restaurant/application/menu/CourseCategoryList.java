package com.company.restaurant.application.menu;

import com.company.restaurant.model.CourseCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class CourseCategoryList extends DatabaseFunctionality<CourseCategory> {
    private static final String[] categoryListHeader = new String[] {
            "Category Id",
            "Category name"
    };

    @Override
    protected String[] getListHeader() {
        return categoryListHeader;
    }

    @Override
    protected CourseCategory findOneObject() {
        return null;
    }

    @Override
    protected List<CourseCategory> findData() {
        return getRestaurantController().findAllCourseCategories();
    }

    @Override
    protected String[] dataSetRowDataToStringArray(CourseCategory courseCategory) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(courseCategory.getId()));
        arrayList.add(courseCategory.getName());

        return arrayList.toArray(new String[arrayList.size()]);
    }
}
