package com.company.restaurant.application.data.service;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class ItemChooserProto<ObjectType, ItemType, ItemKeyFieldType>
        extends ObjectChooserProto<ItemType, ItemKeyFieldType>
        implements ItemChooser<ObjectType, ItemType> {

    public ItemChooserProto(ObjectTableList<ItemType> objectTableList) {
        super(objectTableList);
    }



    @Override
    public ItemType chooseObjectFromList(ObjectType object) {
        return null;
    }

    @Override
    protected ItemType findObject(ItemKeyFieldType objectKeyFieldValue) {
        return null;
    }

    @Override
    protected ItemKeyFieldType readObjectKeyFieldValue() {
        return null;
    }
}
