package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.chooser.CourseCategoryChooser;
import com.company.restaurant.application.data.list.CourseCategoryTableList;
import com.company.restaurant.application.menu.service.DatabaseMenuItem;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.model.Course;
import com.company.restaurant.model.CourseCategory;
import com.company.util.Util;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseAdd extends DatabaseMenuItem implements MenuItem {
    private static final String ENTER_NAME_MESSAGE = "Please, enter course name";
    private static final String ENTER_WEIGHT_MESSAGE = "Please, enter course weight";
    private static final String ENTER_COST_MESSAGE = "Please, enter course cost";

    public MenuItemCourseAdd(String itemText) {
        super(itemText);
    }

    @Override
    protected void performAction() {
        String courseName = Util.readInputString(ENTER_NAME_MESSAGE, false);
        if (courseName != null && !courseName.isEmpty()) {
            CourseCategory courseCategory = new CourseCategoryChooser(new CourseCategoryTableList()).chooseObjectFromList();
            if (courseCategory != null) {
                Float weight = Util.readInputFloat(ENTER_WEIGHT_MESSAGE, true);
                Float cost = Util.readInputFloat(ENTER_COST_MESSAGE, false);

                Course course = new Course();
                course.setName(courseName);
                course.setCategoryId(courseCategory.getId());
                course.setWeight(weight);
                course.setCost(cost);

                getRestaurantController().addCourse(course);
                dataHasBeenSuccessfullyAddedMessage();
            }
        }
    }
}
