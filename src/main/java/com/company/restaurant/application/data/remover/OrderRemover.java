package com.company.restaurant.application.data.remover;

import com.company.restaurant.application.data.chooser.ObjectChooser;
import com.company.restaurant.model.Order;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class OrderRemover extends ObjectRemoverProto<Order> {
    public OrderRemover(ObjectChooser<Order> objectChooser) {
        super(objectChooser);
    }

    @Override
    protected String delObject(Order order) {
        return getRestaurantController().delOrder(order);
    }
}
