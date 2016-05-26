package com.company.restaurant.application.menu;

import com.company.restaurant.model.Course;
import com.company.restaurant.model.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class CourseList extends DatabaseFunctionality<Course> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter course id";

    private static final String[] listHeader = new String[] {
            "Course Id",
            "Course name"
    };

    @Override
    protected String[] getListHeader() {
        return listHeader;
    }

    @Override
    protected Course findOneObject() {
        return null;
    }

    @Override
    protected List<Course> findData() {
        return getRestaurantController().findAllCourses();
    }

    @Override
    protected String[] dataSetRowDataToStringArray(Course course) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(course.getCourseId()));
        arrayList.add(course.getName());

        return arrayList.toArray(new String[arrayList.size()]);
    }

    @Override
    protected boolean validateId(Integer Id) {
        return (getRestaurantController().findCourseById(Id) != null);
    }

    public int readId() {
        return super.readId(ENTER_IDENTIFIER_MESSAGE);
    }
}
