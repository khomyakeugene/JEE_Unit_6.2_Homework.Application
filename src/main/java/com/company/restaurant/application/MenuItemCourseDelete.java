package com.company.restaurant.application;

import com.company.restaurant.model.Course;
import com.company.util.MenuItem;
import com.company.util.Util;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemCourseDelete extends MenuItemCourseFind implements MenuItem {
    public MenuItemCourseDelete(String itemText) {
        super(itemText);
    }

    @Override
    public void menuAction() {
        deleteCourse();
    }

    private void deleteCourse() {
        readCourseName();

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
