package com.company.restaurant.application.menu;

import com.company.restaurant.model.Course;
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
    public void menuAction() {
        addCourse();
    }

    private void addCourse() {
        String courseName = readCourseName();
        if (courseName != null && !courseName.isEmpty()) {
            int courseCategoryId = new CourseCategoryList().readId();
            Float weight = Util.readInputFloat(ENTER_WEIGHT_MESSAGE, true);
            Float cost = Util.readInputFloat(ENTER_COST_MESSAGE, false);

            Course course = new Course();
            course.setName(courseName);
            course.setCategoryId(courseCategoryId);
            course.setWeight(weight);
            course.setCost(cost);

            try {
                getRestaurantController().addCourse(course);
                dataHasBeenSuccessfullyAddedMessage();
            } catch (Exception e) {
                errorMessage(e.getMessage());
            }
        }
    }
}
