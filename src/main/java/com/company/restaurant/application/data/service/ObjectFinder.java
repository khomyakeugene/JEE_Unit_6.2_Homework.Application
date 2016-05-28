package com.company.restaurant.application.data.service;

import java.util.List;

/**
 * Created by Yevhen on 28.05.2016.
 */
public interface ObjectFinder<T> {
    List<T> findAndDisplayObjectList();
}
