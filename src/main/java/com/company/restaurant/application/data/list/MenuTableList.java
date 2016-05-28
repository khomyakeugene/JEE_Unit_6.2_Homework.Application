package com.company.restaurant.application.data.list;

import com.company.restaurant.application.data.service.ObjectTableList;
import com.company.restaurant.application.data.service.ObjectTableListProto;
import com.company.restaurant.model.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class MenuTableList extends ObjectTableListProto<Menu> implements ObjectTableList<Menu> {
    private static final String[] listHeader = new String[] {
            "Menu Id",
            "Menu name"
    };

    @Override
    protected List<Menu> prepareObjectList() {
        return getRestaurantController().findAllMenus();
    }

    @Override
    protected String[] getListHeader() {
        return listHeader;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(Menu menu) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(menu.getId()));
        arrayList.add(menu.getName());

        return arrayList.toArray(new String[arrayList.size()]);
    }
}