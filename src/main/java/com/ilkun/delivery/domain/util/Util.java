package com.ilkun.delivery.domain.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Util {

    private static final int PRECISION = 2;

    public static double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(PRECISION, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
