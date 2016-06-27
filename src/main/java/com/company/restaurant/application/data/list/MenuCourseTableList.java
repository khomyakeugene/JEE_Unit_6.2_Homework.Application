package com.company.restaurant.application.data.list;

import com.company.restaurant.application.data.list.proto.ItemTableList;
import com.company.restaurant.application.data.list.proto.ItemTableListProto;
import com.company.restaurant.controllers.MenuController;
import com.company.restaurant.model.Course;
import com.company.restaurant.model.Menu;

import java.util.ArrayList;
import java.util.Collection;

import static com.company.util.Util.toStringMaskNullAsEmpty;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class MenuCourseTableList extends ItemTableListProto<Menu, Course>
        implements ItemTableList<Menu, Course> {
    private static final String MENU_IS_EMPTY_MESSAGE = "Menu is empty";
    private static final String[] listHeader = new String[] {
            "Course Id",
            "Course name",
            "Category name",
            "Weight",
            "Cost"
    };

    private MenuController menuController;

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    @Override
    public Collection<Course> prepareItemList(Menu menu) {
        return menuController.findMenuCourses(menu);
    }

    @Override
    protected String[] getListHeader() {
        return listHeader;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(Course course) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(course.getCourseId()));
        arrayList.add(course.getName());
        arrayList.add(course.getCourseCategory().getName());
        arrayList.add(toStringMaskNullAsEmpty(course.getWeight()));
        arrayList.add(toStringMaskNullAsEmpty(course.getCost()));

        return arrayList.toArray(new String[arrayList.size()]);
    }

    @Override
    protected void listDataHasNotBeenFoundMessage() {
        errorMessage(MENU_IS_EMPTY_MESSAGE);
    }
}
