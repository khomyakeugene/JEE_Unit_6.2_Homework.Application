package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.list.OpenOrderTableList;
import com.company.restaurant.model.Order;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class OpenOrderChooser extends ObjectChooserProto<Order, Integer> implements ObjectChooser<Order> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter order identifier";

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

    public static ObjectChooser<Order> newInstance() {
        OpenOrderChooser orderChooser = new OpenOrderChooser();
        orderChooser.setObjectTableList(new OpenOrderTableList());

        return orderChooser;
    }
}
