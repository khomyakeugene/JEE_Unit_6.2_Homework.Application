package com.company.restaurant.application.data.list;

import com.company.restaurant.model.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class TableTableList extends ObjectTableListProto<Table> implements ObjectTableList<Table> {
    private static final String[] listHeader = new String[] {
            "Table number"
    };

    @Override
    public List<Table> prepareObjectList() {
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
}
