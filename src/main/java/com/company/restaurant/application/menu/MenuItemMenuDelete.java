package com.company.restaurant.application.menu;

import com.company.restaurant.model.Menu;
import com.company.util.Util;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuDelete extends MenuItemMenuFind implements MenuItem {
    public MenuItemMenuDelete(String itemText) {
        super(itemText);
    }

    @Override
    public void menuAction() {
        deleteCourse();
    }

    private void deleteCourse() {
        readMenuName();

        Menu menu = findOneObject();
        if (menu == null) {
            dataHasNotBeenFoundMessage();
        } else {
            String errorMessage = getRestaurantController().delMenu(menuName);
            if (errorMessage != null && !errorMessage.isEmpty()) {
                Util.printMessage(errorMessage);
            } else {
                dataHasBeenSuccessfullyDeletedMessage();
            }
        }
    }
}
