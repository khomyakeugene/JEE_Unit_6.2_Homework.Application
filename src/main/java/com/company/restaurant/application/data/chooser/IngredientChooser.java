package com.company.restaurant.application.data.chooser;

import com.company.restaurant.application.data.list.IngredientTableList;
import com.company.restaurant.model.Ingredient;

/**
 * Created by Yevhen on 29.05.2016.
 */
public class IngredientChooser extends ObjectChooserProto<Ingredient, Integer>
        implements ObjectChooser<Ingredient>  {
    private static final String ENTER_IDENTIFIER_MESSAGE = "Please, enter ingredient identifier";

    @Override
    protected Ingredient findObject(Integer ingredientId) {
        return getIngredientDao().findIngredientById(ingredientId);
    }

    @Override
    protected Integer readKeyFieldValue() {
        return readIntegerKeyFieldValue();
    }

    @Override
    protected String getEnterIdentifierMessage() {
        return ENTER_IDENTIFIER_MESSAGE;
    }

    public static ObjectChooser<Ingredient> newInstance() {
        IngredientChooser ingredientChooser = new IngredientChooser();
        ingredientChooser.setObjectTableList(new IngredientTableList());

        return ingredientChooser;
    }
}
