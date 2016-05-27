package com.company.restaurant.application.data.service;

import com.company.util.Util;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class ItemAdder<ObjectType, ItemType, ObjectKeyFieldType, ItemKeyFieldType,
        ObjectChooserType extends ObjectChooser<ObjectType, ObjectKeyFieldType>,
        ItemChooserType extends ObjectChooser<ItemType, ItemKeyFieldType>> {
    private ObjectChooserType objectChooser;
    private ItemChooserType itemChooser;

    public ItemAdder(ObjectChooserType objectChooser, ItemChooserType itemChooser) {
        this.objectChooser = objectChooser;
        this.itemChooser = itemChooser;
    }

    protected void errorMessage(String message) {
        Util.printMessage(message);
    }

    protected String addItemToObject(ObjectType object, ItemType item) {
        return null;
    }

    public String addItemsToObject() {
        String result = null;

        ObjectType object = objectChooser.chooseObjectFromList();
        if (object != null) {
            ItemType item;
            do {
                item = itemChooser.chooseObjectFromList();
                if (item != null) {
                    result = addItemToObject(object, item);
                    if (result != null && !result.isEmpty()) {
                        errorMessage(result);
                        item = null;
                    }
                }
            } while (item != null && result == null);
        }

        return (result == null || result.isEmpty()) ? null : result;
    }
}
