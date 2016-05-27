package com.company.restaurant.application.data;

import com.company.util.AlignmentType;
import com.company.util.TableBuilder;
import com.company.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 27.05.2016.
 */
public abstract class ObjectTableList<ObjectType> extends DatabaseService {
    protected static final String DATA_HAS_NOT_BEEN_FOUND_MESSAGE = "Data has not been found";

    protected abstract List<ObjectType> prepareObjectList();

    protected abstract String[] getListHeader();

    protected abstract String[] dataSetRowDataToStringArray(ObjectType dataSetRow);

    protected void errorMessage(String message) {
        Util.printMessage(message);
    }

    protected void listDataHasNotBeenFoundMessage() {
        errorMessage(DATA_HAS_NOT_BEEN_FOUND_MESSAGE);
    }

    protected List<ObjectType> displayObjectList() {
        List<ObjectType> data = prepareObjectList();

        if (data != null && data.size() > 0) {
            ArrayList<String[]> arrayList = new ArrayList<>();

            String[] listHeader = getListHeader();
            arrayList.add(listHeader);
            data.forEach(e -> arrayList.add(dataSetRowDataToStringArray(e)));
            Util.printTable(TableBuilder.buildTable(arrayList.toArray(new String[arrayList.size()][listHeader.length]),
                    AlignmentType.LEFT, false));
        } else {
            listDataHasNotBeenFoundMessage();
        }

        return data;
    }
}
