package com.company.restaurant.application.data.adder;

import com.company.restaurant.application.data.chooser.IngredientChooser;
import com.company.restaurant.application.data.chooser.PortionChooser;
import com.company.restaurant.application.data.list.IngredientTableList;
import com.company.restaurant.application.data.list.ObjectTableList;
import com.company.restaurant.application.data.list.PortionTableList;
import com.company.restaurant.application.data.list.WarehouseTableList;
import com.company.restaurant.model.Ingredient;
import com.company.restaurant.model.Portion;
import com.company.restaurant.model.Warehouse;
import com.company.util.Util;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class WarehouseAdder extends ObjectAdderProto<Warehouse> implements ObjectAdder<Warehouse> {
    private static final String ENTER_INGREDIENT_AMOUNT_MESSAGE = "Please, enter ingredient amount";

    private IngredientChooser ingredientChooser = new IngredientChooser(new IngredientTableList());
    private PortionChooser portionChooser = new PortionChooser(new PortionTableList());

    public WarehouseAdder(ObjectTableList<Warehouse> objectTableList) {
        super(objectTableList);
    }

    @Override
    protected Warehouse addObject() {
        Warehouse result = null;

        Ingredient ingredient = ingredientChooser.chooseObjectFromList();
        if (ingredient != null) {
            Portion portion = portionChooser.chooseObjectFromList();
            if (portion != null) {
                Float amount = Util.readInputFloat(ENTER_INGREDIENT_AMOUNT_MESSAGE, true);
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
        return new WarehouseAdder(new WarehouseTableList());
    }
}
