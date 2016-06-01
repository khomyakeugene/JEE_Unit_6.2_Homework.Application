package com.company.restaurant.application.data.adder;

import com.company.restaurant.application.data.chooser.CourseChooser;
import com.company.restaurant.application.data.chooser.EmployeeChooser;
import com.company.restaurant.application.data.chooser.ObjectChooser;
import com.company.restaurant.application.data.list.CookedCourseTableList;
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
    private static final String ALREADY_COOKED_COURSES_MESSAGE = "Already cooked courses:";

    private ObjectChooser<Course> courseChooser = CourseChooser.newInstance();
    private ObjectChooser<Employee>  employeeChooser = EmployeeChooser.newInstance();

    @Override
    protected CookedCourse addObject() {
        CookedCourse result = null;

        Course course = courseChooser.chooseObjectFromList();
        if (course != null) {
            Employee employee = employeeChooser.chooseObjectFromList();
            if (employee != null) {
                Float weight = Util.readInputPositiveFloat(ENTER_WEIGHT_MESSAGE, true);
                if (weight != null) {
                    getRestaurantController().addCookedCourse(course, employee, weight);
                    dataHasBeenSuccessfullyAddedMessage();

                    // Unfortunately, "right now" just "manually imitation" here (hope - temporarily...)  ...
                    result = new CookedCourse();
                    result.setCourseId(course.getCourseId());
                    result.setEmployeeId(employee.getEmployeeId());
                    result.setCookWeight(weight);
                }
            }
        }

        return result;
    }

    public static ObjectAdderProto<CookedCourse> newInstance() {
        CookedCourseAdder cookedCourseAdder = new CookedCourseAdder();
        cookedCourseAdder.setObjectTableList(new CookedCourseTableList());

        return cookedCourseAdder;
    }

    @Override
    protected String getExistingDataMessage() {
        return ALREADY_COOKED_COURSES_MESSAGE;
    }
}
