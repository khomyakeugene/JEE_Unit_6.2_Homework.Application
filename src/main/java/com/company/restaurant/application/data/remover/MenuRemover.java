package com.company.restaurant.application.data.remover;

import com.company.restaurant.application.data.service.ObjectChooser;
import com.company.restaurant.application.data.service.ObjectRemoverProto;
import com.company.restaurant.model.Menu;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class MenuRemover extends ObjectRemoverProto<Menu> {
    public MenuRemover(ObjectChooser<Menu> objectChooser) {
        super(objectChooser);
    }

    @Override
    protected String delObject(Menu menu) {
        return getRestaurantController().delMenu(menu);
    }
}
