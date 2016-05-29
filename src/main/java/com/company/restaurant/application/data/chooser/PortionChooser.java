package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.list.ObjectTableList;
import com.company.restaurant.model.Portion;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class PortionChooser extends ObjectChooserProto<Portion, Integer>  {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter portion identifier";

    public PortionChooser(ObjectTableList<Portion> objectTableList) {
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
}
