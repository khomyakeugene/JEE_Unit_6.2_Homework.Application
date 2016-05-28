package com.company.restaurant.application.data.service;

import com.company.util.Util;

/**
 * Created by Yevhen on 28.05.2016.
 */
public abstract class ObjectFinderAndChooserProto<ObjectType, ObjectKeyFieldType> extends DatabaseService {
    private static final String ENTER_NAME_MESSAGE = "Please, enter name";
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter identifier";

    protected ObjectTableList<ObjectType> objectTableList;

    public ObjectFinderAndChooserProto(ObjectTableList<ObjectType> objectTableList) {
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
}
