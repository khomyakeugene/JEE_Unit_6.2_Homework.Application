package com.company.restaurant.application.menu;

import com.company.restaurant.model.Course;
import com.company.util.Util;

import java.util.List;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseDelete extends MenuItemCourseFind implements MenuItem {
    public MenuItemCourseDelete(String itemText) {
        super(itemText);
    }

    @Override
    protected List<Course> findData() {
        return getRestaurantController().findAllCourses();
    }

    @Override
    public void menuAction() {
        deleteCourse();
    }

    private void deleteCourse() {
        // Show all data
        tableList();

        if (!readCourseName().isEmpty()) {
            Course course = findOneObject();
            if (course == null) {
                dataHasNotBeenFoundMessage();
            } else {
                String errorMessage = getRestaurantController().delCourse(course);
                if (errorMessage != null && !errorMessage.isEmpty()) {
                    Util.printMessage(errorMessage);
                } else {
                    dataHasBeenSuccessfullyDeletedMessage();
                }
            }
        }
    }
}
