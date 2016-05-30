package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.list.ObjectTableList;
import com.company.restaurant.application.data.list.TableTableList;
import com.company.restaurant.model.Table;

/**
 * Created by Yevhen on 27.05.2016.
 */
public class TableChooser extends ObjectChooserProto<Table, Integer> implements ObjectChooser<Table> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter table number";

    private TableChooser(ObjectTableList<Table> objectTableList) {
        super(objectTableList);
    }

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }

    @Override
    protected Table findObject(Integer tableNumber) {
        return getRestaurantController().findTableByNumber(tableNumber);
    }

    @Override
    protected Integer readKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }

    public static ObjectChooser<Table> newInstance() {
        return new TableChooser(new TableTableList());
    }
}
