package com.company.restaurant.application.data.collector;

import com.company.restaurant.controllers.CourseController;
import com.company.restaurant.model.Course;
import com.company.restaurant.model.Order;
import com.company.restaurant.model.OrderCourse;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class OrderCourseCollector extends ItemCollectorProto<Order, Course, OrderCourse>
        implements ItemCollector<Order> {

    protected CourseController courseController;

    public void setCourseController(CourseController courseController) {
        this.courseController = courseController;
    }

    @Override
    protected void addItemToObject(Order order, Course course) {
        getOrderController().addCourseToOrder(order, course, 1);
    }

    @Override
    protected void delItemFromObject(Order order, OrderCourse orderCourse) {
        getOrderController().takeCourseFromOrder(order,
                courseController.findCourseById(orderCourse.getCourseId()), 1);

    }
}
