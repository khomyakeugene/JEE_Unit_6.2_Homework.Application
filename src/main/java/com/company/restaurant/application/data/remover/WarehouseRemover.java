package com.company.restaurant.application.data.remover;

import com.company.restaurant.application.data.chooser.ObjectChooser;
import com.company.restaurant.application.data.chooser.PortionChooser;
import com.company.restaurant.application.data.chooser.WarehouseChooser;
import com.company.restaurant.application.data.list.WarehouseTableList;
import com.company.restaurant.model.Portion;
import com.company.restaurant.model.Warehouse;
import com.company.util.Util;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class WarehouseRemover extends ObjectRemoverProto<Warehouse>  implements ObjectRemover<Warehouse>   {
    private static final String ENTER_INGREDIENT_AMOUNT_MESSAGE = "Please, enter ingredient amount";

    private WarehouseTableList warehouseTableList = new WarehouseTableList();
    private ObjectChooser<Portion> portionChooser = PortionChooser.newInstance();

    private WarehouseRemover(ObjectChooser<Warehouse> objectChooser) {
        super(objectChooser);
    }

    @Override
    protected String delObject(Warehouse warehouse) {
        getRestaurantController().takeIngredientFromWarehouse(
                getIngredientDao().findIngredientById(warehouse.getIngredientId()),
                getPortionDao().findPortionById(warehouse.getPortionId()),
                warehouse.getAmount());

        return null;
    }

    @Override
    protected Warehouse chooseObjectFromList() {
        Warehouse result = super.chooseObjectFromList();
        if (result != null) {
            // Show only this ingredient
            warehouseTableList.displayObjectList(
                    getRestaurantController().findIngredientInWarehouseById(result.getIngredientId()));
            // Get potion id
            Portion portion = portionChooser.chooseObjectFromList();
            if (portion != null) {
                result.setPortionId(portion.getPortionId());

                Float amount = Util.readInputPositiveFloat(ENTER_INGREDIENT_AMOUNT_MESSAGE, false);
                if (amount != null) {
                    result.setAmount(amount);

                    return result;
                }
            }
        }

        return null;
    }

    public static ObjectRemover<Warehouse> newInstance() {
        return new WarehouseRemover(WarehouseChooser.newInstance());
    }
}
