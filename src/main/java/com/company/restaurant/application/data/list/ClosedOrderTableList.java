package com.company.restaurant.application.data.list;

import com.company.restaurant.application.data.service.ObjectTableList;
import com.company.restaurant.model.Order;

import java.util.List;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class ClosedOrderTableList extends OrderTableList implements ObjectTableList<Order> {
    @Override
    protected List<Order> prepareObjectList() {
        return getRestaurantController().findAllClosedOrders();
    }
}
