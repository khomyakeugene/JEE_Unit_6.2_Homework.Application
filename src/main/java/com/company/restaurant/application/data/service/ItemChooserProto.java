package com.company.restaurant.application.data.service;

/**
 * Created by Yevhen on 28.05.2016.
 */
public abstract class ItemChooserProto<ObjectType, ItemType, ItemKeyFieldType>
        extends ObjectChooserProto<ItemType, ItemKeyFieldType>
        implements ItemChooser<ObjectType, ItemType> {

    protected ItemTableList<ObjectType, ItemType> itemTableList;

    public ItemChooserProto(ItemTableList<ObjectType, ItemType> itemTableList) {
        super(itemTableList);

        this.itemTableList = itemTableList;
    }

    @Override
    protected abstract ItemType findObject(ItemKeyFieldType objectKeyFieldValue);

    @Override
    protected abstract ItemKeyFieldType readObjectKeyFieldValue();

    @Override
    public ItemType chooseItemFromList(ObjectType object) {
        return chooseObjectFromList(itemTableList.prepareItemList(object));
    }
}
