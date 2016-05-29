package com.company.restaurant.application.data.list;

import com.company.restaurant.application.data.service.ItemTableList;
import com.company.restaurant.application.data.service.ItemTableListProto;
import com.company.restaurant.model.Menu;
import com.company.restaurant.model.MenuCourseList;

import java.util.ArrayList;
import java.util.List;

import static com.company.util.Util.toStringMaskNullAsEmpty;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class MenuCourseTableList extends ItemTableListProto<Menu, MenuCourseList>
        implements ItemTableList<Menu, MenuCourseList> {
    private static final String[] listHeader = new String[] {
            "Course Id",
            "Course name",
            "Category name",
            "Weight",
            "Cost",
            "Number in menu"
    };

    @Override
    public List<MenuCourseList> prepareItemList(Menu menu) {
        return getRestaurantController().findMenuCourses(menu);
    }

    @Override
    protected String[] getListHeader() {
        return listHeader;
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
    @Override
    public List<MenuCourseList> prepareObjectList() {
        return getRestaurantController().findMenuCourses(null);
    }
}
