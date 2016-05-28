package com.company.restaurant.application.data.list;

import com.company.restaurant.application.data.service.ObjectTableList;
import com.company.restaurant.application.data.service.ObjectTableListProto;
import com.company.restaurant.model.Order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Yevhen on 28.05.2016.
 */
public abstract class OrderTableList extends ObjectTableListProto<Order> implements ObjectTableList<Order> {
    private static final String[] listHeader = new String[] {
            "Order Id",
            "Order number",
            "Order datetime",
            "Status",
            "Personnel name",
            "Table number"
    };

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");

    @Override
    protected String[] getListHeader() {
        return listHeader;
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
}
