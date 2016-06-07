package com.company.restaurant.application.data.converter;

import com.company.restaurant.application.data.service.ObjectProcessorProto;
import com.company.restaurant.model.Order;

/**
 * Created by Yevhen on 01.06.2016.
 */
public class OrderCloser extends ObjectProcessorProto<Order> {
    private static final String ORDER_HAS_BEEN_CLOSED_PATTERN = "Order with number <%s> has been closed";

    @Override
    protected String processObject(Order order) {
        getOrderController().closeOrder(order);

        return null;
    }

    @Override
    protected String getActionHasBeenSuccessfullyPerformedMessage(Order order) {
        return String.format(ORDER_HAS_BEEN_CLOSED_PATTERN, order.getOrderNumber());
    }
}
