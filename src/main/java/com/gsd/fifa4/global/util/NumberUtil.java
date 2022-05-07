package com.gsd.fifa4.global.util;

import lombok.experimental.UtilityClass;

/**
 * Created by Yohan lee
 * Created on 2021-01-29.
 **/

public class NumberUtil {

    public static int calculatePersent(int baseValue, int divideValue) {
        if(baseValue == 0) {
            return 0;
        }
        Double baseValueD = Integer.valueOf(baseValue).doubleValue();
        Double divideValueD = Integer.valueOf(divideValue).doubleValue();
        double result = (divideValueD / baseValueD) * 100;
        return (int) result;
    }
}
