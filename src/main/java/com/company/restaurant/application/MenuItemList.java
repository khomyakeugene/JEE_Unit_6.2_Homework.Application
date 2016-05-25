package com.company.restaurant.application;

import com.company.util.AlignmentType;
import com.company.util.MenuItem;
import com.company.util.TableBuilder;
import com.company.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 25.05.2016.
 */
public abstract class MenuItemList<T> extends DatabaseMenuItem implements MenuItem {
    public MenuItemList(String itemText) {
        super(itemText);
    }

    protected abstract String[] getListHeader();

    protected abstract List<T> findData();

    protected abstract String[] dataSetRowDataToStringArray(T dataSetRow);

    protected void tableList() {
        ArrayList<String[]> arrayList = new ArrayList<>();

        String[] listHeader = getListHeader();
        arrayList.add(listHeader);
        findData().forEach(e -> {arrayList.add(dataSetRowDataToStringArray(e));});
        Util.printTable(TableBuilder.buildTable(arrayList.toArray(new String[arrayList.size()][listHeader.length]),
                AlignmentType.LEFT, false));
    }

}
