package com.company.restaurant.application.menu;

import com.company.restaurant.model.Course;
import com.company.restaurant.model.Menu;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuAddCourseToMenu extends MenuItemMenuFind implements MenuItem {
    public MenuItemMenuAddCourseToMenu(String itemText) {
        super(itemText);
    }

    @Override
    protected void executeAction() {
        addCourseToMenu();
    }

    private void addCourseToMenu() {
        readMenuName();
        Menu menu = checkOneObjectExistence();
        if (menu != null) {
            // To show new menu content further
            MenuCoursesList menuCoursesList = new MenuCoursesList(menu);
            // Show all courses
            MenuItemCourseWholeList menuItemCourseWholeList = new MenuItemCourseWholeList("");
            menuItemCourseWholeList.tableList();

            // Get course names
            MenuItemCourseFind menuItemCourseFind = new MenuItemCourseFind("");
            String courseName;
            do {
                courseName = menuItemCourseFind.readCourseName();
                if (courseName != null && !courseName.isEmpty()) {
                    Course course = menuItemCourseFind.checkOneObjectExistence();
                    if (course != null) {
                        getRestaurantController().addCourseToMenu(menu, course);
                        dataHasBeenSuccessfullyAddedMessage();
                        // Show new menu content
                        menuCoursesList.tableList();
                    }
                }
            } while (courseName != null && !courseName.isEmpty());
        }
    }
}
