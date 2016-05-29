package com.company.restaurant.application.data.adder;

import com.company.restaurant.application.data.list.ObjectTableList;
import com.company.restaurant.application.data.service.DatabaseService;

import java.util.List;

/**
 * Created by Yevhen on 29.05.2016.
 */
public abstract class ObjectAdderProto<T> extends DatabaseService implements ObjectAdder<T> {
    private ObjectTableList<T> objectTableList;

    public ObjectAdderProto(ObjectTableList<T> objectTableList) {
        this.objectTableList = objectTableList;
    }

    protected abstract T addObject();

    @Override
    public List<T> addObjects() {
        List<T> result ;
        T object;

        do {
            result = objectTableList.displayObjectList(objectTableList.prepareObjectList());
            object = addObject();
        } while (object != null);

        return result;
    }
}
