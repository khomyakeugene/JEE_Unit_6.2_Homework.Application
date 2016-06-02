package com.company.restaurant.application.data.remover;

import com.company.restaurant.application.data.chooser.ObjectChooser;
import com.company.restaurant.application.data.service.DatabaseService;
import com.company.restaurant.application.data.service.Executor;

/**
 * Created by Yevhen on 28.05.2016.
 */
public abstract class ObjectRemoverProto<T> extends DatabaseService implements Executor {
    private ObjectChooser<T> objectChooser;

    public void setObjectChooser(ObjectChooser<T> objectChooser) {
        this.objectChooser = objectChooser;
    }

    protected abstract String delObject(T object);

    protected T chooseObjectFromList() {
        return objectChooser.chooseObjectFromList();
    }

    private String deleteObjects() {
        String result = null;

        T object;
        do {
            object = chooseObjectFromList();
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

    @Override
    public void execute() {
        deleteObjects();
    }
}
