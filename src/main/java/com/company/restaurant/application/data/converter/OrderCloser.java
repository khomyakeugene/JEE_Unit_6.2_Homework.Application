package com.company.restaurant.application.data.converter;

import com.company.restaurant.application.data.chooser.ObjectChooser;
import com.company.restaurant.application.data.chooser.OrderChooser;
import com.company.restaurant.application.data.service.DatabaseService;
import com.company.restaurant.model.Order;
import com.company.util.Util;

/**
 * Created by Yevhen on 01.06.2016.
 */
public class OrderCloser extends DatabaseService {
    private static final String ORDER_HAS_BEEN_CLOSED_PATTERN = "Order with number <%s> has been closed";

    private ObjectChooser<Order> orderChooser = OrderChooser.newInstance();

    public void closeOrder() {
        Order order = orderChooser.chooseObjectFromList();
        if (order != null) {
            getRestaurantController().closeOrder(order);
            Util.printMessage(String.format(ORDER_HAS_BEEN_CLOSED_PATTERN, order.getOrderNumber()));
        }
    }
}
