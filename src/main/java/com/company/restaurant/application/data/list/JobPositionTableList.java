package com.company.restaurant.application.data.list;

import com.company.restaurant.model.JobPosition;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class JobPositionTableList extends ObjectTableListProto<JobPosition> implements ObjectTableList<JobPosition> {
    private static final String[] listHeader = new String[] {
            "Job position id",
            "Job position name"
    };

    @Override
    public List<JobPosition> prepareObjectList() {
        return getEmployeeController().findAllJobPositions();
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
}
