package com.company.restaurant.application.data.remover;

import com.company.restaurant.application.data.chooser.ObjectChooser;
import com.company.restaurant.application.data.service.DatabaseService;

/**
 * Created by Yevhen on 28.05.2016.
 */
public abstract class ObjectRemoverProto<T> extends DatabaseService implements ObjectRemover<T> {
    private ObjectChooser<T> objectChooser;

    public ObjectRemoverProto(ObjectChooser<T> objectChooser) {
        this.objectChooser = objectChooser;
    }

    protected abstract String delObject(T object);

    public String deleteObject() {
        String result = null;

        T object;
        do {
            object = objectChooser.chooseObjectFromList();
            if (object != null) {
                result = delObject(object);
                if (result  != null && !result.isEmpty()) {
                    errorMessage(result);
                } else {
                    dataHasBeenSuccessfullyDeletedMessage();
                }
            }
        } while (object != null);

        return result;
    }
}
