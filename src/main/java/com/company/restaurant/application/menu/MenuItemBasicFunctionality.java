package com.company.restaurant.application.menu;

import com.company.util.AlignmentType;
import com.company.util.TableBuilder;
import com.company.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 25.05.2016.
 */
public abstract class MenuItemBasicFunctionality<T> extends DatabaseMenuItem implements MenuItem {
    private static final String DATA_HAS_NOT_BEEN_FOUND_MESSAGE = "Data has not been found";
    private static final String DATA_HAS_BEEN_SUCCESSFULLY_DELETED = "Data has been successfully deleted";
    private static final String DATA_HAS_BEEN_SUCCESSFULLY_ADDED = "Data has been successfully added";

    public MenuItemBasicFunctionality(String itemText) {
        super(itemText);
    }

    protected abstract String[] getListHeader();

    protected abstract T findOneObject();

    protected List<T> findData() {
        ArrayList<T> arrayList = new ArrayList<>();

        T object = findOneObject();
        if (object != null) {
            arrayList.add(object);
        }

        return arrayList;
    }

    protected abstract String[] dataSetRowDataToStringArray(T dataSetRow);

    protected void dataHasNotBeenFoundMessage() {
        Util.printMessage(DATA_HAS_NOT_BEEN_FOUND_MESSAGE);
    }

    protected void dataHasBeenSuccessfullyDeletedMessage() {
        Util.printMessage(DATA_HAS_BEEN_SUCCESSFULLY_DELETED);
    }

    protected void dataHasBeenSuccessfullyAddedMessage() {
        Util.printMessage(DATA_HAS_BEEN_SUCCESSFULLY_ADDED);
    }

    public void tableList() {
        List<T> data = findData();

        if (data == null || data.size() == 0) {
            dataHasNotBeenFoundMessage();
        } else {
            ArrayList<String[]> arrayList = new ArrayList<>();

            String[] listHeader = getListHeader();
            arrayList.add(listHeader);
            data.forEach(e -> arrayList.add(dataSetRowDataToStringArray(e)));
            Util.printTable(TableBuilder.buildTable(arrayList.toArray(new String[arrayList.size()][listHeader.length]),
                    AlignmentType.LEFT, false));
        }
    }

    protected T checkOneObjectExistence() {
        T objject = findOneObject();
        if (objject == null) {
            dataHasNotBeenFoundMessage();
        }

        return objject;
    }
}
