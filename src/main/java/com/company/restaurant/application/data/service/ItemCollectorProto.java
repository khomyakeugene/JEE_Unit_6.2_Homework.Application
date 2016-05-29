package com.company.restaurant.application.data.service;

/**
 * Created by Yevhen on 27.05.2016.
 */
public abstract class ItemCollectorProto<ObjectType, NewItemType, PresentItemType> extends DatabaseService {
    private ObjectChooser<ObjectType> objectChooser;
    private ObjectChooser<NewItemType> newItemChooser;
    private ItemChooser<ObjectType, PresentItemType> presentItemChooser;

    public ItemCollectorProto(ObjectChooser<ObjectType> objectChooser,
                              ObjectChooser<NewItemType> newItemChooser,
                              ItemChooser<ObjectType, PresentItemType> presentItemChooser) {
        this.objectChooser = objectChooser;
        this.newItemChooser = newItemChooser;
        this.presentItemChooser = presentItemChooser;
    }

    protected abstract void addItemToObject(ObjectType object, NewItemType item);

    public void addItemsToObject() {
        ObjectType object = objectChooser.chooseObjectFromList();
        if (object != null) {
            NewItemType item;
            do {
                item = newItemChooser.chooseObjectFromList();
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
