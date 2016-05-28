package com.company.restaurant.application.data.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 28.05.2016.
 */
public abstract class ObjectOneRecordFinderProto<ObjectType, ObjectKeyFieldType>
        extends ObjectFinderAndChooserProto<ObjectType, ObjectKeyFieldType> {

    public ObjectOneRecordFinderProto(ObjectTableList<ObjectType> objectTableList) {
        super(objectTableList);
    }

    public List<ObjectType> findAndDisplayObjectList() {
        List<ObjectType> result = null;

        ObjectKeyFieldType objectKeyFieldValue = readObjectKeyFieldValue();
        if (objectKeyFieldValue != null) {
            ObjectType object = findObject(objectKeyFieldValue);
            if (object != null) {
                result = displayObjectList(object);
            } else {
                objectDataHasNotBeenFoundMessage();
            }
        }

        return result;
    }

    List<ObjectType>  displayObjectList(ObjectType object) {
        List<ObjectType> objects = new ArrayList<>();
        if (object != null) {
            objects.add(object);
        }

        return objectTableList.displayObjectList(objects);
    }
}
