package com.company.restaurant.application.data.finder;

import java.util.List;

/**
 * Created by Yevhen on 30.05.2016.
 */
public interface ObjectFinder<T> {
    List<T> findAndDisplayObjectList();
}
