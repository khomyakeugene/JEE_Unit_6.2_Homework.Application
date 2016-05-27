package com.company.restaurant.application.data;

import com.company.util.Util;

import java.util.List;

/**
 * Created by Yevhen on 27.05.2016.
 */
public abstract class ObjectChooser<ObjectType, ObjectKeyFieldType> extends ObjectTableList<ObjectType> {
    private static final String ENTER_NAME_MESSAGE = "Please, enter name";
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter identifier";

    protected abstract ObjectType findObject(ObjectKeyFieldType objectKeyFieldValue);

    protected abstract ObjectKeyFieldType readObjectKeyFieldValue();

    protected void objectDataHasNotBeenFoundMessage() {
        errorMessage(DATA_HAS_NOT_BEEN_FOUND_MESSAGE);
    }

    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }

    protected String enterNameMessage() {
        return ENTER_NAME_MESSAGE;
    }

    protected String readStringKeyFieldValue() {
        return Util.readInputString(enterNameMessage(), false);
    }

    protected Integer readIntegerKeyFieldValue() {
        return Util.readInputInt(getEnterIdentifierMessage(), false);
    }

    public ObjectType chooseObjectFromList() {
        ObjectType result = null;

        ObjectKeyFieldType objectKeyFieldValue = null;
        do {
            List<ObjectType> list = displayObjectList();
            if (list != null && list.size() > 0) {
                objectKeyFieldValue = readObjectKeyFieldValue();
                if (objectKeyFieldValue != null) {
                    result = findObject(objectKeyFieldValue);
                    if (result == null) {
                        objectDataHasNotBeenFoundMessage();
                    }
                }
            }
        } while (objectKeyFieldValue != null && result == null);

        return result;
    }
}
