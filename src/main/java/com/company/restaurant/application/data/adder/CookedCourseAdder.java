package com.company.restaurant.application.data.adder;

import com.company.restaurant.application.data.chooser.CourseChooser;
import com.company.restaurant.application.data.chooser.EmployeeChooser;
import com.company.restaurant.application.data.list.CookedCourseTableList;
import com.company.restaurant.application.data.list.CourseTableList;
import com.company.restaurant.application.data.list.EmployeeTableList;
import com.company.restaurant.application.data.list.ObjectTableList;
import com.company.restaurant.model.CookedCourse;
import com.company.restaurant.model.Course;
import com.company.restaurant.model.Employee;
import com.company.util.Util;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class CookedCourseAdder extends ObjectAdderProto<CookedCourse> implements ObjectAdder<CookedCourse>   {
    private static final String ENTER_WEIGHT_MESSAGE = "Please, enter course weight";

    private CourseChooser courseChooser = new CourseChooser(new CourseTableList());
    private EmployeeChooser employeeChooser = new EmployeeChooser(new EmployeeTableList());

    public CookedCourseAdder(ObjectTableList<CookedCourse> objectTableList) {
        super(objectTableList);
    }

    @Override
    protected CookedCourse addObject() {
        CookedCourse result = null;

        Course course = courseChooser.chooseObjectFromList();
        if (course != null) {
            Employee employee = employeeChooser.chooseObjectFromList();
            if (employee != null) {
                Float weight = Util.readInputFloat(ENTER_WEIGHT_MESSAGE, true);

                getRestaurantController().addCookedCourse(course, employee, weight);
                dataHasBeenSuccessfullyAddedMessage();

                // Unfortunately, just "manually" here (hope - temporarily...)  ...
                result = new CookedCourse();
                result.setCourseId(course.getCourseId());
                result.setEmployeeId(employee.getEmployeeId());
                result.setCookWeight(weight);
            }
        }

         return result;
    }

    public static ObjectAdderProto<CookedCourse> newInstance() {
        return new CookedCourseAdder(new CookedCourseTableList());
    }
}
