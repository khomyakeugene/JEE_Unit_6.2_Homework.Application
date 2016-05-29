package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.service.ObjectChooserProto;
import com.company.restaurant.application.data.service.ObjectTableList;
import com.company.restaurant.model.Table;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class TableChooser extends ObjectChooserProto<Table, Integer> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter table number";

    public TableChooser(ObjectTableList<Table> objectTableList) {
        super(objectTableList);
    }

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }

    @Override
    protected Table findObject(Integer tableNumber) {
        return getRestaurantController().findTableByNumber(tableNumber);
    }

    @Override
    protected Integer readKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }
}
