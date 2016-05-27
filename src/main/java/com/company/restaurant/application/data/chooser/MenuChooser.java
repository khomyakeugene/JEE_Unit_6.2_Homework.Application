package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.service.ObjectChooserProto;
import com.company.restaurant.application.data.service.ObjectTableList;
import com.company.restaurant.model.Menu;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class MenuChooser extends ObjectChooserProto<Menu, Integer> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter menu identifier";

    public MenuChooser(ObjectTableList<Menu> objectTableList) {
        super(objectTableList);
    }

    @Override
    protected Menu findObject(Integer menuId) {
        return getRestaurantController().findMenuById(menuId);
    }

    @Override
    protected Integer readObjectKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }


    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }
}
