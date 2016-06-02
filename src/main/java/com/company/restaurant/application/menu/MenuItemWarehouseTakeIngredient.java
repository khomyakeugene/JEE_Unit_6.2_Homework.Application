package com.company.restaurant.application.menu;

import com.company.restaurant.application.data.remover.ObjectRemover;
import com.company.restaurant.application.menu.service.MenuItem;
import com.company.restaurant.application.menu.service.SafeMenuItem;
import com.company.restaurant.model.Warehouse;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class MenuItemWarehouseTakeIngredient extends SafeMenuItem implements MenuItem {
    private ObjectRemover<Warehouse> objectRemover;

    public void setObjectRemover(ObjectRemover<Warehouse> objectRemover) {
        this.objectRemover = objectRemover;
    }

    @Override
    protected void performAction() {
        objectRemover.deleteObjects();
    }
}
