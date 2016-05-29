package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.list.ObjectTableList;
import com.company.restaurant.model.Order;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class OrderChooser extends ObjectChooserProto<Order, Integer> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter order identifier";

    public OrderChooser(ObjectTableList<Order> objectTableList) {
        super(objectTableList);
    }

    @Override
    protected Order findObject(Integer orderId) {
        return getRestaurantController().findOrderById(orderId);
    }

    @Override
    protected Integer readKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }
}
