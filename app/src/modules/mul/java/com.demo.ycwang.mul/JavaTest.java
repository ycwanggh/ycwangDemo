package com.demo.ycwang.mul;


import com.demo.ycwang.core.utils.CalculateUtils;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: ycwang
 * @Date: 2019/4/1 10:40
 */
public class JavaTest {


    public static double[] getComplexAmount(double AMOUNT, double RATE, int N) {
        double result[] = new double[2];
        BigDecimal bigDecimalM = new BigDecimal(AMOUNT);
        BigDecimal bigDecimalRate = new BigDecimal(RATE);
        double decRate = CalculateUtils.add(1, bigDecimalRate.doubleValue());
        for (int i = 0; i < N; i++) {
            double nowAmount = CalculateUtils.mul(bigDecimalM.doubleValue(), decRate);
            result[0] = CalculateUtils.add(AMOUNT, nowAmount);
            bigDecimalM = new BigDecimal(result[0]);
        }
        result[1] = AMOUNT * N;
        return result;
    }


    public static double[] getOneComplexAmount(double AMOUNT, double RATE, int N) {
        double result[] = new double[2];
        BigDecimal bigDecimalM = new BigDecimal(AMOUNT);
        double decRate = CalculateUtils.add(1, RATE);
        for (int i = 1; i < N; i++) {
            decRate *= (1 + RATE);
        }
        double allAmount = CalculateUtils.mul(bigDecimalM.doubleValue(), decRate);
        result[0] = allAmount;
        result[1] = AMOUNT;
        return result;
    }


}
