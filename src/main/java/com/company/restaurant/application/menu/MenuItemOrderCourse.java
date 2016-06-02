package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.collector.ItemCollector;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;
import com.company.restaurant.model.Order;

/**
 * Created by Yevhen on 29.05.2016.
 */
public abstract class MenuItemOrderCourse extends SafeMenuItem implements MenuItem {
    protected ItemCollector<Order> orderCourseCollector;

    public void setOrderCourseCollector(ItemCollector<Order> orderCourseCollector) {
        this.orderCourseCollector = orderCourseCollector;
    }
}
