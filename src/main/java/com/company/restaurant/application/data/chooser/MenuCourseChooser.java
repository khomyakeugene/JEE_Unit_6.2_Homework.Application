package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.service.ItemChooser;
import com.company.restaurant.application.data.service.ItemChooserProto;
import com.company.restaurant.application.data.service.ItemTableList;
import com.company.restaurant.model.Menu;
import com.company.restaurant.model.MenuCourseList;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class MenuCourseChooser extends ItemChooserProto<Menu, MenuCourseList, Integer>
        implements ItemChooser<Menu, MenuCourseList> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter course identifier";
    private static final String MENU_IS_EMPTY_MESSAGE = "Menu is empty";

    public MenuCourseChooser(ItemTableList<Menu, MenuCourseList> itemTableList) {
        super(itemTableList);
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
        return getRestaurantController().findMenuCourseByCourseId(menu, courseId);
    }
}
