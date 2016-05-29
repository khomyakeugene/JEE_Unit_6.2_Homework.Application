package com.company.restaurant.application.data.service;

import java.util.List;

/**
 * Created by Yevhen on 28.05.2016.
 */
public interface ItemChooser<ObjectType, ItemType> {
    List<ItemType> displayItemList(ObjectType object);

    ItemType chooseItemFromList(ObjectType object);
}
