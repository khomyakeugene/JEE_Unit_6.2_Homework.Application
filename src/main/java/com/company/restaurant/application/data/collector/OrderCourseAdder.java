package com.company.restaurant.application.data.collector;

import com.company.restaurant.application.menu.service.Executor;

/**
 * Created by Yevhen on 02.06.2016.
 */
public class OrderCourseAdder extends OrderCourseCollector implements Executor {
    @Override
    public void execute() {
        addItemsToObject();
    }
}
