package com.company.restaurant.application.data.service;

import java.util.List;

/**
 * Created by Yevhen on 27.05.2016.
 */
public interface ObjectChooser<T> {
    List<T> displayObjectList();

    T chooseObjectFromList();
}
