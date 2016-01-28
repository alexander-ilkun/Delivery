package com.ilkun.delivery.service;

import com.ilkun.delivery.domain.Address;
import com.ilkun.delivery.domain.BonusCard;
import com.ilkun.delivery.domain.Customer;
import com.ilkun.delivery.domain.Order;
import com.ilkun.delivery.domain.Order.OrderType;
import com.ilkun.delivery.domain.Pizza;
import com.ilkun.delivery.repository.OrderRepository;
import com.ilkun.delivery.util.Util;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alexander-ilkun
 */
public class SimpleOrderService implements OrderService {

    private static final int PRECISION = 2;
    private static final int DISCOUNT_PIZZAS_NUMBER = 5;
    private static final double PIZZA_DISCOUNT = 0.3;
    private static final double DISCOUNT_BONUS_CARD = 0.1;
    private static final double MAX_DISCOUNT_BONUS_CARD = 0.3;
    private final OrderRepository orderRepository;
    private final PizzaService pizzaService;
    private final BonusCardService bonusCardService;

    public SimpleOrderService(OrderRepository orderRepository,
            PizzaService pizzaService, BonusCardService bonusCardService) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
        this.bonusCardService = bonusCardService;
    }

    @Override
    public Order placeNewOrder(Customer customer, Integer[] pizzasID,
            Integer[] pizzasNumber) {
        Map<Pizza, Integer> pizzas = new HashMap<>();
        Address address = customer.getAddresses().get(0); // TODO : choose correct address
        double total;
        for (int i = 0; i < pizzasID.length; i++) {
            pizzas.put(getPizzaByID(pizzasID[i]), pizzasNumber[i]);
        }
        total = getTotalPrice(customer, pizzas);
        Order newOrder = new Order(customer, address, pizzas,
                total, OrderType.NEW);
        saveOrder(newOrder);  // set Order Id and save Order to in-memory list
        return newOrder;
    }

    public Order changeOrderType(Integer id, OrderType newType) {
        Order order = orderRepository.find(id);
        OrderType curType = order.getType();
        if (newType.ordinal() >= curType.ordinal()
                && !curType.equals(OrderType.CANCELLED)) {
            order.setType(newType);
            return order;
        }
        throw new IllegalArgumentException("Can not change order type");
    }

    private double getTotalPrice(Customer customer, Map<Pizza, Integer> pizzas) {
        double curTotal = 0.0;
        int numberOfPizzas = 0;
        BonusCard bonusCard = customer.getBonusCard();
        for (Map.Entry<Pizza, Integer> entry : pizzas.entrySet()) {
            numberOfPizzas += entry.getValue();
            curTotal += entry.getKey().getPrice() * entry.getValue();
        }
        if (numberOfPizzas >= DISCOUNT_PIZZAS_NUMBER) {
            curTotal -= getDiscountByNumberOfPizzas(pizzas);
        }
        if (bonusCard != null) {
            curTotal -= getDiscountByBonusCard(bonusCard, curTotal);
            depositBonusCard(bonusCard, curTotal);
        }
        return curTotal;
    }

    private double getDiscountByBonusCard(BonusCard bonusCard, double curTotal) {
        double maxDiscount = Util.round(curTotal * MAX_DISCOUNT_BONUS_CARD,
                PRECISION);
        double discount = Util.round(bonusCard.getAmount() * DISCOUNT_BONUS_CARD,
                PRECISION);
        if (Double.compare(discount, maxDiscount) >= 0) {
            bonusCardService.withdraw(bonusCard, maxDiscount);
            return maxDiscount;
        } else {
            bonusCardService.withdraw(bonusCard, discount);
            return discount;
        }
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

    private void depositBonusCard(BonusCard bonusCard, double total) {
        bonusCardService.deposit(bonusCard, total);
    }

    private Pizza getPizzaByID(Integer id) {
        return pizzaService.find(id);
    }

    private void saveOrder(Order newOrder) {
        orderRepository.save(newOrder);
    }
}
