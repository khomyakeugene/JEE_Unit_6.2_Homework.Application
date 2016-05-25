package com.company.restaurant.application.menu;

import com.company.restaurant.model.Course;

import java.util.ArrayList;

import static com.company.util.Util.toStringMaskNullAsEmpty;

/**
 * Created by Yevhen on 25.05.2016.
 */
public abstract class MenuItemCourseList extends MenuItemList<Course>  implements MenuItem {
    private static final String[] courseListHeader = new String[] {
            "Course Id",
            "Course name",
            "Category name",
            "Weight",
            "Cost"
    };

    public MenuItemCourseList(String itemText) {
        super(itemText);
    }

    @Override
    protected String[] getListHeader() {
        return courseListHeader;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(Course course) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(course.getCourseId()));
        arrayList.add(course.getName());
        arrayList.add(course.getCourseCategoryName());
        arrayList.add(toStringMaskNullAsEmpty(course.getWeight()));
        arrayList.add(toStringMaskNullAsEmpty(course.getCost()));

        return arrayList.toArray(new String[arrayList.size()]);
    }
}
