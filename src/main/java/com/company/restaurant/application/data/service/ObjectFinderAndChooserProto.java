package com.company.restaurant.application.data.service;

/**
 * Created by Yevhen on 28.05.2016.
 */
public abstract class ObjectFinderAndChooserProto<ObjectType, ObjectKeyFieldType>
        extends DataFinderAndChooserProto<ObjectKeyFieldType> {

    protected ObjectTableList<ObjectType> objectTableList;

    public ObjectFinderAndChooserProto(ObjectTableList<ObjectType> objectTableList) {
        this.objectTableList = objectTableList;
    }
}
