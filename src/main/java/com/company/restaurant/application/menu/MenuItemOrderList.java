package com.company.restaurant.application.menu;

import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.model.Order;
import com.company.util.Util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Yevhen on 25.05.2016.
 */
public abstract class MenuItemOrderList extends ExtendedDatabaseMenuItem<Order> implements MenuItem {
    private static final String ENTER_ORDER_NUMBER_MESSAGE = "Please, enter order number";
    private static final String ENTER_ORDER_ID_MESSAGE = "Please, enter order id";

    private static final String[] orderListHeader = new String[] {
            "Order Id",
            "Order number",
            "Order datetime",
            "Status",
            "Personnel name",
            "Table number"
    };

    private String orderNumber;
    protected Integer orderId;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");

    public MenuItemOrderList(String itemText) {
        super(itemText);
    }

    protected String readOrderNumber() {
        orderNumber = Util.readInputString(ENTER_ORDER_NUMBER_MESSAGE).trim();

        return orderNumber;
    }

    protected Integer readOrderId() {
        orderId = Util.readInputInt(ENTER_ORDER_ID_MESSAGE, true);

        return orderId;
    }

    @Override
    protected String[] getListHeader() {
        return orderListHeader;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(Order order) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(order.getOrderId()));
        arrayList.add(order.getOrderNumber());
        arrayList.add(simpleDateFormat.format(order.getOrderDatetime()));
        arrayList.add(order.getStateTypeName());
        arrayList.add(order.getEmployeeFirstName() + " " + order.getEmployeeSecondName());
        arrayList.add(Integer.toString(order.getTableNumber()));

        return arrayList.toArray(new String[arrayList.size()]);
    }

    @Override
    protected Order findOneObject() {
        return findFirstObject();
    }
}
