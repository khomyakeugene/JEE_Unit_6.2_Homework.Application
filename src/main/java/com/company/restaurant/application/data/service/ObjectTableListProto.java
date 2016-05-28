package com.company.restaurant.application.data.service;

import com.company.util.AlignmentType;
import com.company.util.TableBuilder;
import com.company.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 27.05.2016.
 */
public abstract class ObjectTableListProto<T> extends DatabaseService implements ObjectTableList<T> {
    protected static final String DATA_HAS_NOT_BEEN_FOUND_MESSAGE = "Data has not been found";

    protected abstract List<T> prepareObjectList();

    protected abstract String[] getListHeader();

    protected abstract String[] dataSetRowDataToStringArray(T dataSetRow);

    protected void errorMessage(String message) {
        Util.printMessage(message);
    }

    protected void listDataHasNotBeenFoundMessage() {
        errorMessage(DATA_HAS_NOT_BEEN_FOUND_MESSAGE);
    }

    @Override
    public List<T> displayObjectList(List<T> objects) {
        if (objects != null && objects.size() > 0) {
            ArrayList<String[]> arrayList = new ArrayList<>();

            String[] listHeader = getListHeader();
            arrayList.add(listHeader);
            objects.forEach(e -> arrayList.add(dataSetRowDataToStringArray(e)));
            Util.printTable(TableBuilder.buildTable(arrayList.toArray(new String[arrayList.size()][listHeader.length]),
                    AlignmentType.LEFT, false));
        } else {
            listDataHasNotBeenFoundMessage();
        }

        return objects;
    }

    @Override
    public List<T> displayObjectList(T object) {
        List<T> objects = new ArrayList<>();
        if (object != null) {
            objects.add(object);
        }

        return displayObjectList(objects);
    }

    @Override
    public List<T> displayObjectList() {
        return displayObjectList(prepareObjectList());
    }
}
