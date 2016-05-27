package com.company.restaurant.application.data;

import com.company.restaurant.model.SimpleDic;

import java.util.ArrayList;
import java.util.List;

import static com.company.util.Util.readInputString;

/**
 * Created by Yevhen on 25.05.2016.
 */
public abstract class SimpleDicFunctionality<T extends SimpleDic> extends DatabaseService<T> {
    private static final String[] listHeader = new String[] {
            "Id",
            "Name"
    };

    @Override
    protected String[] getListHeader() {
        return listHeader;
    }

    @Override
    protected abstract T findOneObject();

    @Override
    protected abstract List<T> findData();

    protected abstract String getEnterIdentifierMessage();

    @Override
    protected String[] dataSetRowDataToStringArray(T simpleDic) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(simpleDic.getId()));
        arrayList.add(simpleDic.getName());

        return arrayList.toArray(new String[arrayList.size()]);
    }

    public int readId() {
        return super.readId(getEnterIdentifierMessage());
    }
}
