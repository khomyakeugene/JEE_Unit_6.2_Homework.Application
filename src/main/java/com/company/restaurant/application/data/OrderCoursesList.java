package com.company.restaurant.application.data;

import com.company.restaurant.application.menu.DatabaseService;
import com.company.restaurant.model.Order;
import com.company.restaurant.model.OrderCourse;

import java.util.ArrayList;
import java.util.List;

import static com.company.util.Util.toStringMaskNullAsEmpty;

/**
 * Created by Yevhen on 26.05.2016.
 */
public class OrderCoursesList extends DatabaseService<OrderCourse> {
    private static final String[] courseListHeader = new String[] {
            "Course Id",
            "Course name",
            "Category name",
            "Weight",
            "Cost",
            "Quantity in order"
    };
    private Order order;

    public OrderCoursesList(Order order) {
        this.order = order;
    }

    @Override
    protected String[] getListHeader() {
        return courseListHeader;
    }

    @Override
    protected OrderCourse findOneObject() {
        return null;
    }

    @Override
    protected List<OrderCourse> findData() {
        return getRestaurantController().findAllOrderCourses(order);
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
}
