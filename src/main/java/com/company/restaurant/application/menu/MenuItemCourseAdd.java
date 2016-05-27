package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.CourseCategoryChooser;
import com.company.restaurant.model.Course;
import com.company.restaurant.model.CourseCategory;
import com.company.util.Util;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseAdd extends MenuItemCourseFind implements MenuItem {
    private static final String ENTER_WEIGHT_MESSAGE = "Please, enter course weight";
    private static final String ENTER_COST_MESSAGE = "Please, enter course cost";

    public MenuItemCourseAdd(String itemText) {
        super(itemText);
    }

    @Override
    protected void executeAction() {
        addCourse();
    }

    private void addCourse() {
        String courseName = readCourseName();
        if (courseName != null && !courseName.isEmpty()) {
            CourseCategory courseCategory = new CourseCategoryChooser().chooseObjectFromList();
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
