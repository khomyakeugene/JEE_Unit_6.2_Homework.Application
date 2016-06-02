package com.company.restaurant.application.data.remover;

import com.company.restaurant.model.Order;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class OrderRemover extends ObjectRemoverProto<Order> {
    @Override
    protected String deleteObject(Order order) {
        return getRestaurantController().delOrder(order);
    }
}
