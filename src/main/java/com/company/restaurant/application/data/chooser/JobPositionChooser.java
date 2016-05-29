package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.list.ObjectTableList;
import com.company.restaurant.model.JobPosition;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class JobPositionChooser extends ObjectChooserProto<JobPosition, Integer> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter job position identifier";

    public JobPositionChooser(ObjectTableList<JobPosition> objectTableList) {
        super(objectTableList);
    }

    @Override
    protected JobPosition findObject(Integer jobPositionId) {
        return getRestaurantController().findJobPositionById(jobPositionId);
    }

    @Override
    protected Integer readKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }
}
