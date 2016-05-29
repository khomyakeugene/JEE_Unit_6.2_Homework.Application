package com.company.restaurant.application.data.service;

/**
 * Created by Yevhen on 28.05.2016.
 */
public interface ItemChooser<ObjectType, ItemType> {
    ItemType chooseItemFromList(ObjectType object);
}
