package com.company.restaurant.application.data.service;

/**
 * Created by Yevhen on 27.05.2016.
 */
public abstract class ItemCollectorProto<ObjectType, ItemType> extends DatabaseService {
    private ObjectChooser<ObjectType> objectChooser;
    private ObjectChooser<ItemType> itemChooser;

    public ItemCollectorProto(ObjectChooser<ObjectType> objectChooser, ObjectChooser<ItemType> itemChooser) {
        this.objectChooser = objectChooser;
        this.itemChooser = itemChooser;
    }

    protected abstract void addItemToObject(ObjectType object, ItemType item);

    public void addItemsToObject() {
        ObjectType object = objectChooser.chooseObjectFromList();
        if (object != null) {
            ItemType item;
            do {
                item = itemChooser.chooseObjectFromList();
                if (item != null) {
                    try {
                        addItemToObject(object, item);
                        dataHasBeenSuccessfullyAddedMessage();
                    } catch (Exception e) {
                        e.printStackTrace();
                        item = null;
                    }
                }
            } while (item != null);
        }
    }
}
