package com.company.restaurant.application.data;

import com.company.util.AlignmentType;
import com.company.util.TableBuilder;
import com.company.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 27.05.2016.
 */
public abstract class ObjectChooser<ObjectType, ObjectKeyFieldType> extends DatabaseService {
    private class Generic<T> {
        T type;

        public Class getGenericType() {
            return type.getClass();
        }
    }

    private static final String DATA_HAS_NOT_BEEN_FOUND_MESSAGE = "Data has not been found";
    private static final String ENTER_NAME_MESSAGE = "Please, enter name";
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter identifier";

    protected abstract List<ObjectType> prepareObjectList();

    protected abstract String[] getListHeader();

    protected abstract String[] dataSetRowDataToStringArray(ObjectType dataSetRow);

    protected abstract ObjectType findObject(ObjectKeyFieldType objectKeyFieldValue);

    private void errorMessage(String message) {
        Util.printMessage(message);
    }

    protected void objectDataHasNotBeenFoundMessage() {
        errorMessage(DATA_HAS_NOT_BEEN_FOUND_MESSAGE);
    }

    protected void listDataHasNotBeenFoundMessage() {
        errorMessage(DATA_HAS_NOT_BEEN_FOUND_MESSAGE);
    }

    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }

    protected String enterNameMessage() {
        return ENTER_NAME_MESSAGE;
    }

    private boolean objectKeyFieldTypeIsThisClass(Class<? extends java.io.Serializable> thisClass) {
        return ((new Generic<ObjectKeyFieldType>()).getGenericType() == thisClass);
    }

    private boolean objectKeyFieldTypeIsString() {
        return objectKeyFieldTypeIsThisClass(String.class);
    }

    private boolean objectKeyFieldTypeIsInteger() {
        return objectKeyFieldTypeIsThisClass(Integer.class);
    }

    protected ObjectKeyFieldType readObjectKeyFieldValue() {
        if (objectKeyFieldTypeIsString() ) {
            return (ObjectKeyFieldType)Util.readInputString(enterNameMessage(), true);

        } else if (objectKeyFieldTypeIsInteger() ) {
            return (ObjectKeyFieldType)Util.readInputInt(getEnterIdentifierMessage(), true);
        }

        return null;
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

    protected ObjectType chooseObjectFromList() {
        ObjectType result = null;

        List<ObjectType> list = displayObjectList();
        if (list != null && list.size() > 0) {
            ObjectKeyFieldType objectKeyFieldValue = readObjectKeyFieldValue();
            if (objectKeyFieldValue != null) {
                result = findObject(objectKeyFieldValue);
                if (result == null) {
                    objectDataHasNotBeenFoundMessage();
                }
            }
        }

        return result;
    }
}
