package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.list.TableTableList;
import com.company.restaurant.model.Table;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class TableChooser extends ObjectChooserProto<Table, Integer> implements ObjectChooser<Table> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter table id";

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }

    @Override
    protected Table findObject(Integer tableId) {
        return getRestaurantController().findTableById(tableId);
    }

    @Override
    protected Integer readKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }

    public static ObjectChooser<Table> newInstance() {
        TableChooser tableChooser = new TableChooser();
        tableChooser.setObjectTableList(new TableTableList());

        return tableChooser;
    }
}
