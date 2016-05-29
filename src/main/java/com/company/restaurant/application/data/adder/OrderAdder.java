package com.company.restaurant.application.data.adder;

import com.company.restaurant.application.data.chooser.EmployeeChooser;
import com.company.restaurant.application.data.chooser.TableChooser;
import com.company.restaurant.application.data.collector.ItemCollector;
import com.company.restaurant.application.data.collector.OrderCourseCollector;
import com.company.restaurant.application.data.list.EmployeeTableList;
import com.company.restaurant.application.data.list.ObjectTableList;
import com.company.restaurant.application.data.list.OpenOrderTableList;
import com.company.restaurant.application.data.list.TableTableList;
import com.company.restaurant.model.Employee;
import com.company.restaurant.model.Order;
import com.company.restaurant.model.Table;
import com.company.util.Util;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class OrderAdder extends ObjectAdderProto<Order> implements ObjectAdder<Order>  {
    private static final String ENTER_ORDER_NUMBER_MESSAGE = "Please, enter order number";

    private EmployeeChooser employeeChooser = new EmployeeChooser(new EmployeeTableList());
    private TableChooser tableChooser = new TableChooser(new TableTableList());
    private ItemCollector<Order> orderCourseCollector = OrderCourseCollector.newInstance();

    public OrderAdder(ObjectTableList<Order> objectTableList) {
        super(objectTableList);
    }

    private Order addOrder() {
        Order result = null;

        String orderNumber = Util.readInputString(ENTER_ORDER_NUMBER_MESSAGE);
        if (orderNumber != null && !orderNumber.isEmpty()) {
            Employee employee = employeeChooser.chooseObjectFromList();
            if (employee != null) {
                Table table = tableChooser.chooseObjectFromList();
                if (table != null) {
                    Order order = new Order();
                    order.setOrderNumber(orderNumber.trim());
                    order.setEmployeeId(employee.getEmployeeId());
                    order.setTableId(table.getTableId());

                    result = getRestaurantController().addOrder(order);
                    dataHasBeenSuccessfullyAddedMessage();
                }
            }
        }

        return result;
    }


    @Override
    protected Order addObject() {
        Order result = addOrder();
        orderCourseCollector.addItemsToObject(result);

        return result;
    }

    public static ObjectAdder<Order> newInstance() {
        return new OrderAdder(new OpenOrderTableList());
    }
}