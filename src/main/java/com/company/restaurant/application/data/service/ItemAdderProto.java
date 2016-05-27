package com.company.restaurant.application.data.service;

import com.company.util.Util;

/**
 * Created by Yevhen on 27.05.2016.
 */
public abstract class ItemAdderProto<ObjectType, ItemType> extends DatabaseService {
    private ObjectChooser<ObjectType> objectChooser;
    private ObjectChooser<ItemType> itemChooser;

    public ItemAdderProto(ObjectChooser<ObjectType> objectChooser, ObjectChooser<ItemType> itemChooser) {
        this.objectChooser = objectChooser;
        this.itemChooser = itemChooser;
    }

    protected void errorMessage(String message) {
        Util.printMessage(message);
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
