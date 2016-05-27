package com.company.restaurant.application.data.list;

import com.company.restaurant.application.data.service.ObjectTableList;
import com.company.restaurant.application.data.service.ObjectTableListProto;
import com.company.restaurant.model.CourseCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class CourseCategoryTableList extends ObjectTableListProto<CourseCategory>
        implements ObjectTableList<CourseCategory> {
    private static final String[] listHeader = new String[] {
            "Course category id",
            "Course category name"
    };

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
}
