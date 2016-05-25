package com.company.restaurant.application.menu;

import com.company.restaurant.model.SimpleDic;
import com.company.util.Util;

import java.util.ArrayList;
import java.util.List;

import static com.company.util.Util.readInputString;

/**
 * Created by Yevhen on 25.05.2016.
 */
public abstract class SimpleDicFunctionality<T extends SimpleDic> extends DatabaseFunctionality<T> {
    private static final String INVALID_DATA_PATTERN = "%d is invalid <id> value. Please, input <id> again";
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

    protected abstract boolean validateId(Integer Id);

    @Override
    protected String[] dataSetRowDataToStringArray(T simpleDic) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(simpleDic.getId()));
        arrayList.add(simpleDic.getName());

        return arrayList.toArray(new String[arrayList.size()]);
    }

    public int readId() {
        int result;

        boolean needToRepeat;
        do {
            tableList();

            result = Util.readInputInt(getEnterIdentifierMessage(), true);
            needToRepeat = !validateId(result);
            if (needToRepeat) {
                Util.printMessage(INVALID_DATA_PATTERN);
            }
        } while (needToRepeat);

        return result;
    }
}
