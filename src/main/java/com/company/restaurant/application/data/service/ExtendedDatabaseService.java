package com.company.restaurant.application.data.service;

import com.company.util.AlignmentType;
import com.company.util.TableBuilder;
import com.company.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 25.05.2016.
 */
public abstract class ExtendedDatabaseService<T> extends DatabaseService {
    private static final String DATA_HAS_NOT_BEEN_FOUND_MESSAGE = "Data has not been found";
    private static final String DATA_HAS_BEEN_SUCCESSFULLY_DELETED = "Data has been successfully deleted";
    private static final String DATA_HAS_BEEN_SUCCESSFULLY_ADDED = "Data has been successfully added";
    private static final String ACTION_HAS_BEEN_SUCCESSFULLY_PERFORMED = "The action has been successfully performed";
    private static final String INVALID_DATA_PATTERN = "%d is invalid <id> value. Please, input <id> again";

    protected void errorMessage(String message) {
        Util.printMessage(message);
    }

    protected void listDataHasNotBeenFoundMessage() {
        errorMessage(DATA_HAS_NOT_BEEN_FOUND_MESSAGE);
    }

    protected void oneObjectHasNotBeenFoundMessage() {
        errorMessage(DATA_HAS_NOT_BEEN_FOUND_MESSAGE);
    }

    protected void dataHasBeenSuccessfullyDeletedMessage() {
        errorMessage(DATA_HAS_BEEN_SUCCESSFULLY_DELETED);
    }

    protected void dataHasBeenSuccessfullyAddedMessage() {
        errorMessage(DATA_HAS_BEEN_SUCCESSFULLY_ADDED);
    }

    protected void actionHasBeenSuccessfullyPerformedMessage() {
        Util.printMessage(ACTION_HAS_BEEN_SUCCESSFULLY_PERFORMED);
    }

    protected abstract String[] getListHeader();

    protected abstract T findOneObject();

    protected abstract String[] dataSetRowDataToStringArray(T dataSetRow);

    protected List<T> findData() {
        ArrayList<T> arrayList = new ArrayList<>();

        T object = findOneObject();
        if (object != null) {
            arrayList.add(object);
        }

        return arrayList;
    }

    protected T findFirstObject() {
        List<T> data = findData();

        return (data == null || data.size() == 0) ? null : data.get(0);
    }

    protected boolean validateId(Integer Id) {
        return true;
    }

    public List<T> tableList() {
        List<T> data = findData();

        if (data == null || data.size() == 0) {
            listDataHasNotBeenFoundMessage();
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

    public T checkOneObjectExistence() {
        T object = findOneObject();
        if (object == null) {
            oneObjectHasNotBeenFoundMessage();
        }

        return object;
    }

    protected int readId(String enterIdentifierMessage) {
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

    protected List<T> showInitialList() {
        return tableList();
    }

    protected boolean initialListCanBeEmpty() {
        return true;
    }

    protected void readObjectKeyData() {

    }

    protected String doActionOnDatabaseObject(T object) {
        return null;
    }

    protected void processObject() {
        List<T> list = showInitialList();
        if (initialListCanBeEmpty() || (list != null && list.size() > 0)) {
            readObjectKeyData();
            T object = findOneObject();

            if (object == null) {
                oneObjectHasNotBeenFoundMessage();
            } else {
                String errorMessage = null;
                try {
                    errorMessage = doActionOnDatabaseObject(object);
                } catch (Exception e) {
                    errorMessage(e.getMessage());
                }
                if (errorMessage != null && !errorMessage.isEmpty()) {
                    errorMessage(errorMessage);
                } else {
                    actionHasBeenSuccessfullyPerformedMessage();
                }
            }
        }
    }
}
