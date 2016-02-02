package com.ilkun.delivery.domain;

import com.ilkun.delivery.domain.util.Util;
import java.util.Map;


public class SimpleDiscountManager implements DiscountManager {

    private static final int PRECISION = 2;
    private static final int DISCOUNT_PIZZAS_NUMBER = 5;
    private static final double PIZZA_DISCOUNT = 0.3;
    private static final double DISCOUNT_BONUS_CARD = 0.1;
    private static final double MAX_DISCOUNT_BONUS_CARD = 0.3;

    @Override
    public double getDiscount(Order order) {
        Customer customer = order.getCustomer();
        Map<Pizza, Integer> pizzas = order.getPizzas();
        BonusCard bonusCard = customer.getBonusCard();
        int numberOfPizzas = order.getNumberOfPizzas();
        double curDiscount = 0.0;
        if (numberOfPizzas >= DISCOUNT_PIZZAS_NUMBER) {
            curDiscount += getDiscountByNumberOfPizzas(pizzas);
        }
        if (bonusCard != null) {
            curDiscount += getDiscountByBonusCard(bonusCard, curDiscount);
            bonusCard.deposit(curDiscount);
        }
        return curDiscount;
    }

    private double getDiscountByBonusCard(BonusCard bonusCard, double curTotal) {
        double maxDiscount = Util.round(curTotal * MAX_DISCOUNT_BONUS_CARD,
                PRECISION);
        double discount = Util.round(bonusCard.getAmount() * DISCOUNT_BONUS_CARD,
                PRECISION);
        if (Double.compare(discount, maxDiscount) > 0) {
            discount = maxDiscount;
        }
        bonusCard.withdraw(discount);
        return discount;
    }

    private double getDiscountByNumberOfPizzas(Map<Pizza, Integer> pizzas) {
        double highestDiscount = 0.0;
        double curDiscount;
        for (Map.Entry<Pizza, Integer> entry : pizzas.entrySet()) {
            curDiscount = Util.round(entry.getKey().getPrice()
                    * entry.getValue() * PIZZA_DISCOUNT, PRECISION);
            if (Double.compare(curDiscount, highestDiscount) > 0) {
                highestDiscount = curDiscount;
            }
        }
        return highestDiscount;
    }
    
}
