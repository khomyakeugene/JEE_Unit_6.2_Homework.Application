package com.company.restaurant.application.data.finder;

import com.company.restaurant.application.data.list.ObjectTableList;
import com.company.restaurant.model.Menu;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class MenuFinder extends ObjectOneRecordFinderProto<Menu, String> {
    private static final String ENTER_NAME_MESSAGE = "Please, enter menu name";

    public MenuFinder(ObjectTableList<Menu> objectTableList) {
        super(objectTableList);
    }

    @Override
    protected Menu findObject(String menuName) {
        return getRestaurantController().findMenuByName(menuName);
    }

    @Override
    protected String readKeyFieldValue() {
        return readStringKeyFieldValue();
    }

    @Override
    protected String getEnterNameMessage() {
        return ENTER_NAME_MESSAGE;
    }
}
