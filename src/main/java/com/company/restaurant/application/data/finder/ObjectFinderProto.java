package com.company.restaurant.application.data.finder;

import com.company.restaurant.application.data.service.ObjectFinderAndChooserProto;
import com.company.restaurant.application.menu.service.Executor;

import java.util.List;

/**
 * Created by Yevhen on 28.05.2016.
 */
public abstract class ObjectFinderProto<ObjectType, ObjectKeyFieldType>
        extends ObjectFinderAndChooserProto<ObjectType, ObjectKeyFieldType>
        implements ObjectFinder<ObjectType>, Executor {

    protected abstract List<ObjectType> findObjects(ObjectKeyFieldType objectKeyFieldValue);

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

        ObjectKeyFieldType objectKeyFieldValue = readKeyFieldValue();
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

    @Override
    public void execute() {
        findAndDisplayObjectList();
    }
}
