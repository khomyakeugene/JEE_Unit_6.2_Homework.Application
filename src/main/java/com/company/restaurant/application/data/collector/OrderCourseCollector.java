package com.company.restaurant.application.data.collector;

import com.company.restaurant.application.data.chooser.*;
import com.company.restaurant.model.Course;
import com.company.restaurant.model.Order;
import com.company.restaurant.model.OrderCourse;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class OrderCourseCollector extends ItemCollectorProto<Order, Course, OrderCourse>
        implements ItemCollector<Order> {

    private OrderCourseCollector(ObjectChooser<Order> objectChooser,
                                 ObjectChooser<Course> newItemChooser,
                                 ItemChooser<Order, OrderCourse> presentItemChooser) {
        super(objectChooser, newItemChooser, presentItemChooser);
    }

    @Override
    protected void addItemToObject(Order order, Course course) {
        getRestaurantController().addCourseToOrder(order, course, 1);
    }

    @Override
    protected void delItemFromObject(Order order, OrderCourse orderCourse) {
        getRestaurantController().takeCourseFromOrder(order,
                getRestaurantController().findCourseById(orderCourse.getCourseId()), 1);

    }

    public static ItemCollector<Order> newInstance() {
        return new OrderCourseCollector(
                OrderChooser.newInstance(),
                CourseChooser.newInstance(),
                OrderCourseChooser.newInstance());
    }
}
