package com.company.restaurant.application.data.service;

import com.company.util.Util;

import java.util.List;

/**
 * Created by Yevhen on 27.05.2016.
 */
public abstract class ObjectChooserProto<ObjectType, ObjectKeyFieldType> extends DatabaseService
        implements ObjectChooser<ObjectType> {
    private static final String ENTER_NAME_MESSAGE = "Please, enter name";
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter identifier";

    private ObjectTableList<ObjectType> objectTableList;

    public ObjectChooserProto(ObjectTableList<ObjectType> objectTableList) {
        this.objectTableList = objectTableList;
    }

    protected abstract ObjectType findObject(ObjectKeyFieldType objectKeyFieldValue);

    protected abstract ObjectKeyFieldType readObjectKeyFieldValue();

    protected void objectDataHasNotBeenFoundMessage() {
        oneObjectHasNotBeenFoundMessage();
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
            List<ObjectType> list = objectTableList.displayObjectList();
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
