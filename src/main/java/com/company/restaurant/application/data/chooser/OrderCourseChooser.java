package com.company.restaurant.application.data.chooser;

import com.company.restaurant.controllers.OrderController;
import com.company.restaurant.model.OrderCourse;
import com.company.restaurant.model.OrderView;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class OrderCourseChooser extends ItemChooserProto<OrderView, OrderCourse, Integer>
        implements ItemChooser<OrderView, OrderCourse> {
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
    protected OrderCourse findItem(OrderView orderView, Integer courseId) {
        return orderController.findOrderCourseByCourseId(orderView,courseId);
    }

}
