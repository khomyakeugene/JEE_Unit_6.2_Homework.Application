package com.company.restaurant.application.menu;

import com.company.restaurant.application.RestaurantConsoleApplication;
import com.company.restaurant.controllers.RestaurantController;
import com.company.util.AlignmentType;
import com.company.util.TableBuilder;
import com.company.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 25.05.2016.
 */
public abstract class DatabaseFunctionality<T>  {
    private static final String DATA_HAS_NOT_BEEN_FOUND_MESSAGE = "Data has not been found";
    private static final String DATA_HAS_BEEN_SUCCESSFULLY_DELETED = "Data has been successfully deleted";
    private static final String DATA_HAS_BEEN_SUCCESSFULLY_ADDED = "Data has been successfully added";
    private static final String ACTION_HAS_BEEN_SUCCESSFULLY_PERFORMED = "The action has been successfully performed";
    private static final String INVALID_DATA_PATTERN = "%d is invalid <id> value. Please, input <id> again";

    public RestaurantController getRestaurantController() {
        return RestaurantConsoleApplication.getRestaurantController();
    }

    protected void dataHasNotBeenFoundMessage() {
        Util.printMessage(DATA_HAS_NOT_BEEN_FOUND_MESSAGE);
    }

    protected void dataHasBeenSuccessfullyDeletedMessage() {
        Util.printMessage(DATA_HAS_BEEN_SUCCESSFULLY_DELETED);
    }

    protected void dataHasBeenSuccessfullyAddedMessage() {
        Util.printMessage(DATA_HAS_BEEN_SUCCESSFULLY_ADDED);
    }

    protected void actionHasBeenSuccessfullyPerformedMessage() {
        Util.printMessage(ACTION_HAS_BEEN_SUCCESSFULLY_PERFORMED);
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

    protected boolean validateId(Integer Id) {
        return true;
    }

    public List<T> tableList() {
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

        return data;
    }

    protected T checkOneObjectExistence() {
        T objject = findOneObject();
        if (objject == null) {
            dataHasNotBeenFoundMessage();
        }

        return objject;
    }

    public int readId(String enterIdentifierMessage) {
        int result;

        boolean needToRepeat;
        do {
            tableList();

            result = Util.readInputInt(enterIdentifierMessage, true);
            needToRepeat = !validateId(result);
            if (needToRepeat) {
                Util.printMessage(String.format(INVALID_DATA_PATTERN, result));
            }
        } while (needToRepeat);

        return result;
    }

    protected T readObjectKeyData() {
        return null;
    }

    protected String doActionOnDatabaseObject(T object) {
        return null;
    }

    protected void processObject() {
        tableList();
        readObjectKeyData();

        T object = findOneObject();
        if (object == null) {
            dataHasNotBeenFoundMessage();
        } else {
            String errorMessage = doActionOnDatabaseObject(object);
            if (errorMessage != null && !errorMessage.isEmpty()) {
                Util.printMessage(errorMessage);
            } else {
                actionHasBeenSuccessfullyPerformedMessage();
            }
        }
    }
}
