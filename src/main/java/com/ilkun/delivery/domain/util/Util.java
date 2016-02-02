package com.ilkun.delivery.domain.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author alexander-ilkun
 */
public class Util {

    public static double round(double value, int precision) {
        if (precision < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(precision, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
