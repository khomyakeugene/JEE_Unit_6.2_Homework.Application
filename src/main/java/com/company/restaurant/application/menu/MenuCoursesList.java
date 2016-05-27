package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.ExtendedDatabaseService;
import com.company.restaurant.model.Menu;
import com.company.restaurant.model.MenuCourseList;

import java.util.ArrayList;
import java.util.List;

import static com.company.util.Util.toStringMaskNullAsEmpty;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuCoursesList extends ExtendedDatabaseService<MenuCourseList> {
    private static final String[] courseListHeader = new String[] {
            "Course Id",
            "Course name",
            "Category name",
            "Weight",
            "Cost",
            "Number in menu"
    };

    private Menu menu;

    public MenuCoursesList(Menu menu) {
        this.menu = menu;
    }

    @Override
    protected String[] getListHeader() {
        return courseListHeader;
    }

    @Override
    protected MenuCourseList findOneObject() {
        return null;
    }

    @Override
    protected List<MenuCourseList> findData() {
        return getRestaurantController().findMenuCourses(menu);
    }

    @Override
    protected String[] dataSetRowDataToStringArray(MenuCourseList menuCourseList) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(menuCourseList.getCourseId()));
        arrayList.add(menuCourseList.getCourseName());
        arrayList.add(menuCourseList.getCourseCategoryName());
        arrayList.add(toStringMaskNullAsEmpty(menuCourseList.getCourseWeight()));
        arrayList.add(toStringMaskNullAsEmpty(menuCourseList.getCourseCost()));
        arrayList.add(toStringMaskNullAsEmpty(menuCourseList.getCourseNumber()));

        return arrayList.toArray(new String[arrayList.size()]);
    }
}
