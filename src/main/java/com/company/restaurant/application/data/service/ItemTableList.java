package com.company.restaurant.application.data.service;

import java.util.List;

/**
 * Created by Yevhen on 28.05.2016.
 */
public interface ItemTableList<ObjectType, ItemType>  extends ObjectTableList<ItemType> {
    List<ItemType> prepareItemList(ObjectType object);

    List<ItemType> displayItemList(ObjectType object);
}
