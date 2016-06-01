package com.company.restaurant.application.data.adder;

import com.company.restaurant.application.data.collector.ItemCollector;
import com.company.restaurant.application.data.collector.MenuCourseCollector;
import com.company.restaurant.application.data.list.MenuTableList;
import com.company.restaurant.application.data.list.ObjectTableList;
import com.company.restaurant.model.Menu;
import com.company.util.Util;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class MenuAdder extends ObjectAdderProto<Menu> implements ObjectAdder<Menu> {
    private static final String ENTER_NAME_MESSAGE = "Please, enter menu name";

    private ItemCollector<Menu> menuCourseCollector = MenuCourseCollector.newInstance();

    private Menu addMenu() {
        Menu result = null;

        String menuName = Util.readInputString(ENTER_NAME_MESSAGE);
        if (menuName != null && !menuName.isEmpty()) {
            result = getRestaurantController().addMenu(menuName.trim());
            dataHasBeenSuccessfullyAddedMessage();
        }

        return result;
    }

    @Override
    protected Menu addObject() {
        Menu result = addMenu();
        menuCourseCollector.addItemsToObject(result);

        return result;
    }

    public static ObjectAdder<Menu> newInstance() {
        MenuAdder menuAdder = new MenuAdder();
        menuAdder.setObjectTableList(new MenuTableList());

        return menuAdder;
    }
}
