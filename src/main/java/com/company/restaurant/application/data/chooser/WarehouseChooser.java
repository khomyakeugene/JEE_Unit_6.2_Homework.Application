package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.list.ObjectTableList;
import com.company.restaurant.model.Warehouse;

import java.util.List;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class WarehouseChooser extends ObjectChooserProto<Warehouse, Integer> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter ingredient identifier";

    public WarehouseChooser(ObjectTableList<Warehouse> objectTableList) {
        super(objectTableList);
    }

    @Override
    protected Warehouse findObject(Integer ingredientId) {
        List<Warehouse> list = getRestaurantController().findIngredientInWarehouseById(ingredientId);

        return (list == null || list.size() == 0) ? null : list.get(0);
    }

    @Override
    protected Integer readKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }
}
