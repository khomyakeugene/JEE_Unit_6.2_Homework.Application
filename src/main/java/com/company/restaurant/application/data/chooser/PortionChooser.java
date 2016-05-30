package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.list.ObjectTableList;
import com.company.restaurant.application.data.list.PortionTableList;
import com.company.restaurant.model.Portion;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class PortionChooser extends ObjectChooserProto<Portion, Integer> implements ObjectChooser<Portion> {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter portion identifier";

    private PortionChooser(ObjectTableList<Portion> objectTableList) {
        super(objectTableList);
    }

    @Override
    protected Portion findObject(Integer portionId) {
        return getPortionDao().findPortionById(portionId);
    }

    @Override
    protected Integer readKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }

    public static ObjectChooser<Portion> newInstance() {
        return new PortionChooser(new PortionTableList());
    }
}
