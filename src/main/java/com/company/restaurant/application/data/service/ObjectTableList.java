package com.company.restaurant.application.data.service;

import java.util.List;

/**
 * Created by Yevhen on 28.05.2016.
 */
public interface ObjectTableList<T> {
    List<T> prepareObjectList();

    List<T> displayObjectList(List<T> objects);

    List<T> displayObjectList(T object);

    List<T> displayObjectList();
}
