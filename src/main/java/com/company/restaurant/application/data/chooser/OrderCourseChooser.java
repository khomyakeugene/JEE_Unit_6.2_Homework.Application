package com.company.restaurant.application.data.chooser;

import com.company.restaurant.controllers.OrderController;
import com.company.restaurant.model.Order;
import com.company.restaurant.model.OrderCourse;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class OrderCourseChooser extends ItemChooserProto<Order, OrderCourse, Integer>
        implements ItemChooser<Order, OrderCourse> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter course identifier";

    private OrderController orderController;

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
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
        return orderController.findOrderCourseByCourseId(order,courseId);
    }

}
