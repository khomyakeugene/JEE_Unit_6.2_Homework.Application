package com.company.restaurant.application.data.list;

import com.company.restaurant.model.CookedCourse;
import com.company.util.Util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.company.util.Util.toStringMaskNullAsEmpty;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class CookedCourseTableList extends ObjectTableListProto<CookedCourse>
        implements ObjectTableList<CookedCourse> {
    private static final String THERE_ARE_NO_COOKED_COURSES_YET_MESSAGE = "There are no cooked courses yet";
    private static final String[] listHeader = new String[]{
            "Course Id",
            "Course name",
            "Personnel name",
            "Cooking weight",
            "Cooking datetime"
    };

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");


    @Override
    protected String[] getListHeader() {
        return listHeader;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(CookedCourse cookedCourse) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(cookedCourse.getCourseId()));
        arrayList.add(cookedCourse.getCourseName());
        arrayList.add(cookedCourse.getEmployeeFirstName() + " " + cookedCourse.getEmployeeSecondName());
        arrayList.add(toStringMaskNullAsEmpty(cookedCourse.getCookWeight()));
        arrayList.add(simpleDateFormat.format(cookedCourse.getCookDatetime().getTime()));

        return arrayList.toArray(new String[arrayList.size()]);
    }

    @Override
    public List<CookedCourse> prepareObjectList() {
        return getRestaurantController().findAllCookedCourses();
    }

    @Override
    protected void listDataHasNotBeenFoundMessage() {
        Util.printMessage(THERE_ARE_NO_COOKED_COURSES_YET_MESSAGE);
    }
}
