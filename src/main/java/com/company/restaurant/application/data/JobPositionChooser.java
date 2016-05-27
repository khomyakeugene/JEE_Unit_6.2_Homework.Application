package com.company.restaurant.application.data;

import com.company.restaurant.model.JobPosition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class JobPositionChooser extends ObjectChooser<JobPosition, Integer>  {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter job position identifier";
    private static final String[] listHeader = new String[] {
            "Job position id",
            "Job position name"
    };

    @Override
    protected JobPosition findObject(Integer jobPositionId) {
        return getRestaurantController().findJobPositionById(jobPositionId);
    }

    @Override
    protected Integer readObjectKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }

    @Override
    protected List<JobPosition> prepareObjectList() {
        return getRestaurantController().findAllJobPositions();
    }

    @Override
    protected String[] getListHeader() {
        return listHeader;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(JobPosition jobPosition) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(jobPosition.getId()));
        arrayList.add(jobPosition.getName());

        return arrayList.toArray(new String[arrayList.size()]);
    }

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }
}
