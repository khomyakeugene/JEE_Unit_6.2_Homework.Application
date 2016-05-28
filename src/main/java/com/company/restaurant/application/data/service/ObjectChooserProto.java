package com.company.restaurant.application.data.service;

import java.util.List;

/**
 * Created by Yevhen on 27.05.2016.
 */
public abstract class ObjectChooserProto<ObjectType, ObjectKeyFieldType>
        extends ObjectFinderAndChooserProto<ObjectType, ObjectKeyFieldType>
        implements ObjectChooser<ObjectType> {

    public ObjectChooserProto(ObjectTableList<ObjectType> objectTableList) {
        super(objectTableList);
    }

    protected ObjectType chooseObjectFromList(List<ObjectType> objects) {
        ObjectType result = null;

        ObjectKeyFieldType objectKeyFieldValue = null;
        do {
            List<ObjectType> list = objectTableList.displayObjectList(objects);
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

    public ObjectType chooseObjectFromList() {
        return chooseObjectFromList(objectTableList.prepareObjectList());
    }
}
