package com.company.restaurant.application.data.finder;

import com.company.restaurant.application.data.list.ObjectTableList;
import com.company.restaurant.model.Warehouse;

import java.util.List;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class WarehouseFinder extends ObjectFinderProto<Warehouse, String>  {
    private static final String ENTER_NAME_MESSAGE = "Please, enter ingredient name";

    public WarehouseFinder(ObjectTableList<Warehouse> objectTableList) {
        super(objectTableList);
    }

    @Override
    protected List<Warehouse> findObjects(String name) {
        return getRestaurantController().findIngredientInWarehouseByName(name);
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
