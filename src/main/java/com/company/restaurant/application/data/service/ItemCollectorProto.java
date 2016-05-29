package com.company.restaurant.application.data.service;

/**
 * Created by Yevhen on 27.05.2016.
 */
public abstract class ItemCollectorProto<ObjectType, NewItemType, PresentItemType>
        extends DatabaseService implements ItemCollector {
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

    protected abstract void delItemFromObject(ObjectType object, PresentItemType item);

    public void addItemsToObject() {
        ObjectType object = objectChooser.chooseObjectFromList();
        if (object != null) {
            NewItemType item;
            do {
                // Item list
                presentItemChooser.displayItemList(object);
                // Choose new Item
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

    public void delItemsFromObject() {
        ObjectType object = objectChooser.chooseObjectFromList();
        if (object != null) {
            PresentItemType item;
            do {
                item = presentItemChooser.chooseItemFromList(object);
                if (item != null) {
                    try {
                        delItemFromObject(object, item);
                        dataHasBeenSuccessfullyDeletedMessage();
                    } catch (Exception e) {
                        e.printStackTrace();
                        item = null;
                    }
                }
            } while (item != null);
        }
    }
}
