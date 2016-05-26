package com.company.restaurant.application.menu;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class MenuItemMenuAdd extends MenuItemMenuFind implements MenuItem {
    public MenuItemMenuAdd(String itemText) {
        super(itemText);
    }

    @Override
    protected void executeAction() {
        addMenu();
    }

    private void addMenu() {
        String menuName = readMenuName();
        if (menuName != null && !menuName.isEmpty()) {
            try {
                getRestaurantController().addMenu(menuName);
                dataHasBeenSuccessfullyAddedMessage();
            } catch (Exception e) {
                errorMessage(e.getMessage());
            }
        }
    }
}
