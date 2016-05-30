package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.list.MenuTableList;
import com.company.restaurant.application.data.list.ObjectTableList;
import com.company.restaurant.model.Menu;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class MenuChooser extends ObjectChooserProto<Menu, Integer> implements ObjectChooser<Menu> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter menu identifier";

    private MenuChooser(ObjectTableList<Menu> objectTableList) {
        super(objectTableList);
    }

    @Override
    protected Menu findObject(Integer menuId) {
        return getRestaurantController().findMenuById(menuId);
    }

    @Override
    protected Integer readKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }


    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }

    public static ObjectChooser<Menu> newInstance() {
        return new MenuChooser(new MenuTableList());
    }
}
