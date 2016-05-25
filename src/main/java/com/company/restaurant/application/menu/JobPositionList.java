package com.company.restaurant.application.menu;

import com.company.restaurant.model.JobPosition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 25.05.2016.
 */
public class JobPositionList extends SimpleDicFunctionality<JobPosition> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter job position identifier";

    @Override
    protected JobPosition findOneObject() {
        return null;
    }

    @Override
    protected List<JobPosition> findData() {
        return getRestaurantController().findAllJobPositions();
    }

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }

    @Override
    protected boolean validateId(Integer Id) {
        return (getRestaurantController().findJobPositionById(Id) != null);
    }
}
