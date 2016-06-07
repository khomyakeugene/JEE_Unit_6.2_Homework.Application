package com.company.restaurant.application.data.chooser;

import com.company.restaurant.controllers.MenuController;
import com.company.restaurant.model.Menu;
import com.company.restaurant.model.MenuCourseList;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class MenuCourseChooser extends ItemChooserProto<Menu, MenuCourseList, Integer>
        implements ItemChooser<Menu, MenuCourseList> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter course identifier";

    private MenuController menuController;

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

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
        return menuController.findMenuCourseByCourseId(menu, courseId);
    }

}
