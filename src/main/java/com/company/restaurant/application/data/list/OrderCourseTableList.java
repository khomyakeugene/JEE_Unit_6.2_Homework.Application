package com.company.restaurant.application.data.list;

import com.company.restaurant.model.Order;
import com.company.restaurant.model.OrderCourse;

import java.util.ArrayList;
import java.util.List;

import static com.company.util.Util.toStringMaskNullAsEmpty;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class OrderCourseTableList extends ItemTableListProto<Order, OrderCourse>
        implements ItemTableList<Order, OrderCourse> {
    private static final String ORDER_IS_EMPTY_MESSAGE = "Order is empty";
    private static final String[] listHeader = new String[] {
            "Course Id",
            "Course name",
            "Category name",
            "Weight",
            "Cost",
            "Quantity in order"
    };

    @Override
    public List<OrderCourse> prepareItemList(Order order) {
        return getOrderController().findAllOrderCourses(order);
    }

    @Override
    protected String[] getListHeader() {
        return listHeader;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(OrderCourse orderCourse) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(orderCourse.getCourseId()));
        arrayList.add(orderCourse.getCourseName());
        arrayList.add(orderCourse.getCourseCategoryName());
        arrayList.add(toStringMaskNullAsEmpty(orderCourse.getCourseWeight()));
        arrayList.add(toStringMaskNullAsEmpty(orderCourse.getCourseCost()));
        arrayList.add(Integer.toString(orderCourse.getCourseQuantity()));

        return arrayList.toArray(new String[arrayList.size()]);
    }

    @Override
    protected void listDataHasNotBeenFoundMessage() {
        errorMessage(ORDER_IS_EMPTY_MESSAGE);
    }
}
