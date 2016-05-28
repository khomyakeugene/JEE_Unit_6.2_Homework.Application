package com.company.restaurant.application.data.service;

import java.util.List;

/**
 * Created by Yevhen on 28.05.2016.
 */
public abstract class ObjectFinderProto<ObjectType, ObjectKeyFieldType>
        extends ObjectFinderAndChooserProto<ObjectType, ObjectKeyFieldType> {

    protected abstract List<ObjectType> findObjects(ObjectKeyFieldType objectKeyFieldValue);

    public ObjectFinderProto(ObjectTableList<ObjectType> objectTableList) {
        super(objectTableList);
    }

    @Override
    protected ObjectType findObject(ObjectKeyFieldType objectKeyFieldValue) {
        ObjectType result = null;

        List<ObjectType> objects = findObjects(objectKeyFieldValue);
        if (objects != null && objects.size() > 0) {
            result = objects.get(0);
        }

        return result;
    }

    public List<ObjectType> findAndDisplayObjectList() {
        List<ObjectType> result = null;

        ObjectKeyFieldType objectKeyFieldValue = readObjectKeyFieldValue();
        if (objectKeyFieldValue != null) {
            result = findObjects(objectKeyFieldValue);
            if (result != null && result.size() > 0) {
                result = objectTableList.displayObjectList(result);
            } else {
                objectDataHasNotBeenFoundMessage();
            }
        }

        return result;
    }
}
