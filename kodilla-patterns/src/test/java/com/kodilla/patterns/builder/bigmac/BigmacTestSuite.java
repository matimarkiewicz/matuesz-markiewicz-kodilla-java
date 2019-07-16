package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmac() {

        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .roll(RollType.NORMAL)
                .sauce(SauceType.BARBECUE)
                .ingredients(IngredientsType.ONION)
                .ingredients(IngredientsType.MUSHROOMS)
                .ingredients(IngredientsType.LETTUCE)
                .build();

        System.out.println(bigmac.getRoll());
        System.out.println(bigmac.getSauce());
        System.out.println(bigmac.getIngredients());

        int howManyIngredients = bigmac.getIngredients().size();

        Assert.assertEquals(3, howManyIngredients);
        Assert.assertTrue(bigmac.getIngredients().contains(IngredientsType.MUSHROOMS));
        Assert.assertFalse(bigmac.getIngredients().contains(IngredientsType.BACON));
    }
}
