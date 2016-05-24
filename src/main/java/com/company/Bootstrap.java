package com.company;

import com.company.restaurant.application.RestaurantConsoleApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bootstrap {
    private final static String APPLICATION_CONTEXT_NAME = "application-context.xml";
    private final static String RESTAURANT_APPLICATION_BEAN_NAME = "restaurantConsoleApplication";

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_NAME);
        RestaurantConsoleApplication restaurantConsoleApplication = context.getBean(RESTAURANT_APPLICATION_BEAN_NAME,
                RestaurantConsoleApplication.class);

        restaurantConsoleApplication.run();
    }
}