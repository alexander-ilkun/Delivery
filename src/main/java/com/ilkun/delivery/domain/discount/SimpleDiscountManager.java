package com.ilkun.delivery.domain.discount;

import com.ilkun.delivery.domain.BonusCard;
import com.ilkun.delivery.domain.Order;
import com.ilkun.delivery.domain.OrderDetails;
import com.ilkun.delivery.domain.User;
import com.ilkun.delivery.domain.util.Util;
import java.util.List;

public class SimpleDiscountManager implements DiscountManager {

    private static final int PIZZAS_NUMBER_DISCOUNT = 5;
    private static final double PIZZA_DISCOUNT = 0.3;
    private static final double BONUS_CARD_DISCOUNT = 0.1;
    private static final double MAX_BONUS_CARD_DISCOUNT = 0.3;

    @Override
    public double getDiscount(Order order) {
        User user = order.getUser();
        List<OrderDetails> orderDetails = order.getOrderDetails();
        BonusCard bonusCard = user.getBonusCard();
        int numberOfPizzas = order.getNumberOfPizzas();
        double curDiscount = 0.0;
        if (numberOfPizzas >= PIZZAS_NUMBER_DISCOUNT) {
            curDiscount += getDiscountByNumberOfPizzas(orderDetails);
        }
        if (bonusCard != null) {
            curDiscount += getDiscountByBonusCard(bonusCard, order.getPrice());
            bonusCard.deposit(curDiscount);
        }
        return curDiscount;
    }

    private double getDiscountByBonusCard(BonusCard bonusCard, double curTotal) {
        double maxDiscount = Util.round(curTotal * MAX_BONUS_CARD_DISCOUNT);
        double discount = Util.round(bonusCard.getAmount() * BONUS_CARD_DISCOUNT);
        if (Double.compare(discount, maxDiscount) > 0) {
            discount = maxDiscount;
        }
        bonusCard.withdraw(discount);
        return discount;
    }

    private double getDiscountByNumberOfPizzas(List<OrderDetails> orderDetails) {
        double highestDiscount = 0.0;
        double curDiscount;
        for (OrderDetails ordDet : orderDetails) {
            curDiscount = Util.round(ordDet.getPizzaPrice()
                    * ordDet.getQuantity() * PIZZA_DISCOUNT);
            if (Double.compare(curDiscount, highestDiscount) > 0) {
                highestDiscount = curDiscount;
            }
        }
        return highestDiscount;
    }
}
