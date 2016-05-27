package com.company.restaurant.application.data;

import com.company.restaurant.model.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class TableChooser extends ObjectChooser<Table, Integer> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter table number";

    private static final String[] listHeader = new String[] {
            "Table number"
    };

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }

    @Override
    protected List<Table> prepareObjectList() {
        return getRestaurantController().findAllTables();
    }

    @Override
    protected String[] getListHeader() {
        return listHeader;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(Table table) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(table.getNumber()));

        return arrayList.toArray(new String[arrayList.size()]);
    }

    @Override
    protected Table findObject(Integer tableNumber) {
        return getRestaurantController().findTableByNumber(tableNumber);
    }
}
