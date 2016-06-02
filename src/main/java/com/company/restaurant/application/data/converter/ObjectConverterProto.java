package com.company.restaurant.application.data.converter;

import com.company.restaurant.application.data.chooser.ObjectChooser;
import com.company.restaurant.application.data.service.DatabaseService;
import com.company.util.Util;

/**
 * Created by Yevhen on 02.06.2016.
 */
public abstract class ObjectConverterProto<T> extends DatabaseService {
    private static final String ACTION_HAS_BEEN_SUCCESSFULLY_PERFORMED = "The action has been successfully performed";

    private ObjectChooser<T> objectChooser;

    protected abstract String convert(T object);

    public void setObjectChooser(ObjectChooser<T> objectChooser) {
        this.objectChooser = objectChooser;
    }

    protected String getActionHasBeenSuccessfullyPerformedMessage(T object) {
        return ACTION_HAS_BEEN_SUCCESSFULLY_PERFORMED;
    }

    private void actionHasBeenSuccessfullyPerformedMessage(T object) {
        Util.printMessage(getActionHasBeenSuccessfullyPerformedMessage(object));
    }

    String convertObject() {
        String result = null;

        T object = objectChooser.chooseObjectFromList();
        if (object != null) {
            result = convert(object);
            actionHasBeenSuccessfullyPerformedMessage(object);
        }

        return result;
    }
}
