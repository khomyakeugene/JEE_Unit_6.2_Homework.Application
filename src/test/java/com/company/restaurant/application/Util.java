package com.company.restaurant.application;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by Yevhen on 23.04.2016.
 */
class Util {
    private static final int OPERAND_UPPER_BOUND = 1000;
    private static final int DECIMAL_PRECISION = 2;

    static private Random random = new Random();

    private static double round(double value, int decimalPrecision) {
        double decimalPower = Math.pow(10, decimalPrecision);

        return Math.round(value  * decimalPower) / decimalPower;
    }

    private static double getRandomDouble() {
        return round(random.nextDouble() * OPERAND_UPPER_BOUND, DECIMAL_PRECISION);
    }

    static int getRandomInteger() {
        return random.nextInt(OPERAND_UPPER_BOUND);
    }

    private static boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    static String generateIntegerNumber() {
        return Integer.toString(getRandomInteger());
    }

    private static String generateDoubleNumber() {
        return Double.toString(getRandomDouble());
    }

    static String generateNumber() {
        return Util.getRandomBoolean() ? generateDoubleNumber() : generateIntegerNumber();
    }

    static Date generateDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, random.nextInt(2100));
        calendar.set(Calendar.DAY_OF_YEAR, random.nextInt(365));

        return calendar.getTime();
    }
}
