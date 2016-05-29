package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.service.ItemChooser;
import com.company.restaurant.application.data.service.ItemChooserProto;
import com.company.restaurant.application.data.service.ItemTableList;
import com.company.restaurant.model.Course;
import com.company.restaurant.model.Menu;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class MenuCourseChooser extends ItemChooserProto<Menu, Course, Integer>
        implements ItemChooser<Menu, Course> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter course identifier";

    public MenuCourseChooser(ItemTableList<Menu, Course> itemTableList) {
        super(itemTableList);
    }

    @Override
    protected Course findObject(Integer courseId) {
        return null;
    }

    @Override
    protected Integer readObjectKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }
}
