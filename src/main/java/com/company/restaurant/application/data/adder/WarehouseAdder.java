package com.company.restaurant.application.data.adder;

import com.company.restaurant.application.data.chooser.ObjectChooser;
import com.company.restaurant.application.data.chooser.PortionChooser;
import com.company.restaurant.application.data.list.WarehouseTableList;
import com.company.restaurant.model.Ingredient;
import com.company.restaurant.model.Portion;
import com.company.restaurant.model.Warehouse;
import com.company.util.Util;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class WarehouseAdder extends ObjectAdderProto<Warehouse> implements ObjectAdder<Warehouse> {
    private static final String ALREADY_IN_WAREHOUSE_MESSAGE = "Already in warehouse:";
    private static final String ENTER_INGREDIENT_AMOUNT_MESSAGE = "Please, enter ingredient amount";

    private ObjectChooser<Ingredient> ingredientChooser;
    private ObjectChooser<Portion> portionChooser = PortionChooser.newInstance();

    public void setIngredientChooser(ObjectChooser<Ingredient> ingredientChooser) {
        this.ingredientChooser = ingredientChooser;
    }

    @Override
    protected Warehouse addObject() {
        Warehouse result = null;

        Ingredient ingredient = ingredientChooser.chooseObjectFromList();
        if (ingredient != null) {
            Portion portion = portionChooser.chooseObjectFromList();
            if (portion != null) {
                Float amount = Util.readInputPositiveFloat(ENTER_INGREDIENT_AMOUNT_MESSAGE, false);
                if (amount != null) {
                    getRestaurantController().addIngredientToWarehouse(ingredient, portion, amount);
                    dataHasBeenSuccessfullyAddedMessage();

                    // Unfortunately, just "manually" here (hope - temporarily...)  ...
                    result = new Warehouse();
                    result.setIngredientId(ingredient.getIngredient());
                    result.setPortionId(portion.getPortionId());
                    result.setAmount(amount);
                }
            }
        }

        return result;
    }

    public static ObjectAdder<Warehouse> newInstance() {
        WarehouseAdder warehouseAdder = new WarehouseAdder();
        warehouseAdder.setObjectTableList(new WarehouseTableList());

        return warehouseAdder;
    }

    @Override
    protected String getExistingDataMessage() {
        return ALREADY_IN_WAREHOUSE_MESSAGE;
    }
}
