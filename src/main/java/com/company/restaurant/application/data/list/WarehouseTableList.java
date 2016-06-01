package com.company.restaurant.application.data.list;

import com.company.restaurant.model.Warehouse;
import com.company.util.Util;

import java.util.ArrayList;
import java.util.List;

import static com.company.util.Util.toStringMaskNullAsEmpty;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class WarehouseTableList extends ObjectTableListProto<Warehouse> implements ObjectTableList<Warehouse>  {
    private static final String THERE_ARE_NO_INGREDIENTS_IN_WAREHOUSE_MESSAGE = "There are no ingredients in warehouse";
    private static final String[] listHeader = new String[]{
            "Ingredient Id",
            "Ingredient name",
            "Amount",
            "Portion name"
    };


    @Override
    protected String[] getListHeader() {
        return listHeader;
    }

    @Override
    protected String[] dataSetRowDataToStringArray(Warehouse warehouse) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(Integer.toString(warehouse.getIngredientId()));
        arrayList.add(warehouse.getIngredientName());
        arrayList.add(toStringMaskNullAsEmpty(warehouse.getAmount()));
        arrayList.add(warehouse.getPortionDescription());

        return arrayList.toArray(new String[arrayList.size()]);
    }

    @Override
    public List<Warehouse> prepareObjectList() {
        return getRestaurantController().findAllWarehouseIngredients();
    }

    @Override
    protected void listDataHasNotBeenFoundMessage() {
        Util.printMessage(THERE_ARE_NO_INGREDIENTS_IN_WAREHOUSE_MESSAGE);
    }
}
