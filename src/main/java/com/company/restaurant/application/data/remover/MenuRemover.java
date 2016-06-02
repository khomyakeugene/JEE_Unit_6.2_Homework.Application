package com.company.restaurant.application.data.remover;

import com.company.restaurant.model.Menu;

/**
 * Created by Yevhen on 28.05.2016.
 */
public class MenuRemover extends ObjectRemoverProto<Menu> {
    @Override
    protected String delObject(Menu menu) {
        return getRestaurantController().delMenu(menu);
    }
}
