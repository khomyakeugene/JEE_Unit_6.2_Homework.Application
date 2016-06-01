package com.company.restaurant.application.data.finder;

import com.company.restaurant.application.data.list.WarehouseTableList;
import com.company.restaurant.model.Warehouse;

import java.util.List;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class WarehouseFinder extends ObjectFinderProto<Warehouse, String>
        implements ObjectFinder<Warehouse> {
    private static final String ENTER_NAME_MESSAGE = "Please, enter ingredient name";

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

    public static ObjectFinder<Warehouse> newInstance() {
        WarehouseFinder warehouseFinder = new WarehouseFinder();
        warehouseFinder.setObjectTableList(new WarehouseTableList());

        return warehouseFinder;
    }
}
