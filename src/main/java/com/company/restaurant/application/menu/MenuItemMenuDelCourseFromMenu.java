package com.company.restaurant.application.menu;

import com.company.restaurant.model.Course;
import com.company.restaurant.model.Menu;
import com.company.restaurant.model.MenuCourseList;

import java.util.List;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuDelCourseFromMenu extends MenuItemMenuFind implements MenuItem {
    public MenuItemMenuDelCourseFromMenu(String itemText) {
        super(itemText);
    }

    @Override
    protected void executeAction() {
        delCourseFromMenu();
    }

    private void delCourseFromMenu() {
        readMenuName();
        Menu menu = checkOneObjectExistence();
        if (menu != null) {
            // Show all courses
            MenuCoursesList menuCoursesList = new MenuCoursesList(menu);
            List<MenuCourseList> data = menuCoursesList.tableList();
            if (data != null && data.size() > 0) {
                // Get course names
                MenuItemCourseFind menuItemCourseFind = new MenuItemCourseFind("");
                String courseName;
                do {
                    courseName = menuItemCourseFind.readCourseName();
                    if (courseName != null && !courseName.isEmpty()) {
                        Course course = menuItemCourseFind.checkOneObjectExistence();
                        if (course != null) {
                            getRestaurantController().delCourseFromMenu(menu, course);
                            dataHasBeenSuccessfullyDeletedMessage();
                            // Renew course list
                            data = menuCoursesList.tableList();
                        }
                    }
                } while (data != null && data.size() > 0 && courseName != null && !courseName.isEmpty());
            }
        }
    }
}
