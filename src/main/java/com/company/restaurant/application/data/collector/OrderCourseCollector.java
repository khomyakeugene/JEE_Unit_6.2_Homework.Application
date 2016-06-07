package com.company.restaurant.application.data.collector;

import com.company.restaurant.controllers.CourseController;
import com.company.restaurant.controllers.OrderController;
import com.company.restaurant.model.Course;
import com.company.restaurant.model.Order;
import com.company.restaurant.model.OrderCourse;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class OrderCourseCollector extends ItemCollectorProto<Order, Course, OrderCourse>
        implements ItemCollector<Order> {

    protected OrderController orderController;
    protected CourseController courseController;

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public void setCourseController(CourseController courseController) {
        this.courseController = courseController;
    }

    @Override
    protected void addItemToObject(Order order, Course course) {
        orderController.addCourseToOrder(order, course, 1);
    }

    @Override
    protected void delItemFromObject(Order order, OrderCourse orderCourse) {
        orderController.takeCourseFromOrder(order,
                courseController.findCourseById(orderCourse.getCourseId()), 1);

    }
}
