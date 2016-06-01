package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.list.MenuCourseTableList;
import com.company.restaurant.model.Menu;
import com.company.restaurant.model.MenuCourseList;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class MenuCourseChooser extends ItemChooserProto<Menu, MenuCourseList, Integer>
        implements ItemChooser<Menu, MenuCourseList> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter course identifier";

    @Override
    protected Integer readKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }

    @Override
    protected MenuCourseList findItem(Menu menu, Integer courseId) {
        return getRestaurantController().findMenuCourseByCourseId(menu, courseId);
    }

    public static ItemChooser<Menu, MenuCourseList> newInstance() {
        MenuCourseChooser menuCourseChooser = new MenuCourseChooser();
        menuCourseChooser.setItemTableList(new MenuCourseTableList());

        return menuCourseChooser;
    }
}
