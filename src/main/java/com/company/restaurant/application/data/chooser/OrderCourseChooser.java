package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.list.ItemTableList;
import com.company.restaurant.application.data.list.OrderCourseTableList;
import com.company.restaurant.model.Order;
import com.company.restaurant.model.OrderCourse;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class OrderCourseChooser extends ItemChooserProto<Order, OrderCourse, Integer>
        implements ItemChooser<Order, OrderCourse> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter course identifier";

    private OrderCourseChooser(ItemTableList<Order, OrderCourse> itemTableList) {
        super(itemTableList);
    }

    @Override
    protected Integer readKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }

    @Override
    protected OrderCourse findItem(Order order, Integer courseId) {
        return getRestaurantController().findOrderCourseByCourseId(order,courseId);
    }

    public static ItemChooser<Order, OrderCourse> newInstance() {
        return new OrderCourseChooser(new OrderCourseTableList());
    }
}
