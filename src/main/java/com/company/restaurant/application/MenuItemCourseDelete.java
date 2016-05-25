package com.company.restaurant.application;

import com.company.restaurant.model.Course;
import com.company.util.MenuItem;

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
            getRestaurantController().delCourse(course);
            dataHasBeenSuccessfullyDeletedMessage();
        }
    }
}
