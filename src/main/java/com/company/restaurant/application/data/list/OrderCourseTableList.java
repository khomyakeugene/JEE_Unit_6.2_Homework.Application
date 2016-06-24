package com.company.restaurant.application.data.list;

import com.company.restaurant.controllers.OrderController;
import com.company.restaurant.model.Course;
import com.company.restaurant.model.Order;

import java.util.ArrayList;
import java.util.List;

import static com.company.util.Util.toStringMaskNullAsEmpty;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class OrderCourseTableList extends ItemTableListProto<Order, Course>
        implements ItemTableList<Order, Course> {
    private static final String ORDER_IS_EMPTY_MESSAGE = "Order is empty";
    private static final String[] listHeader = new String[] {
            "Course Id",
            "Course name",
            "Category name",
            "Weight",
            "Cost"
    };

    private OrderController orderController;

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }


    @Override
    public List<Course> prepareItemList(Order order) {
        return orderController.findAllOrderCourses(order);
    }

    @Override
    protected String[] getListHeader() {
        return listHeader;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(Course course) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(course.getCourseId()));
        arrayList.add(course.getName());
        arrayList.add(course.getCourseCategoryName());
        arrayList.add(toStringMaskNullAsEmpty(course.getWeight()));
        arrayList.add(toStringMaskNullAsEmpty(course.getCost()));

        return arrayList.toArray(new String[arrayList.size()]);
    }

    @Override
    protected void listDataHasNotBeenFoundMessage() {
        errorMessage(ORDER_IS_EMPTY_MESSAGE);
    }
}
