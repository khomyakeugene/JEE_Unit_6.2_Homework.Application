package com.company.util;

import com.company.restaurant.application.menu.MenuItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Yevgen on 06.01.2016.
 */

public class Util {
    private final static String CODE_MENU_ITEM_PATTERN = "%d. %s";
    private final static String PLEASE_REPEAT_ENTER = "%s was generated with data \"%s\". Please, repeat enter action";

    public static String toString(Object object) {
        String result;
        if (object == null) {
            result = "null";
        } else {
            result = object.toString();
            if (object instanceof String) {
                result =  "\"" + result + "\"";
            }
        }

        return result;
    }

    public static String toStringMaskNullAsEmpty(Object object) {
        return (object == null) ? "" : object.toString();
    }

    private static void printLine(String message) {
        System.out.print(message);
    }

    public static void printMessage(String message) {
        printLine(message + "\n");
    }

    public static String readInputString(String invitationMessage) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        printMessage(invitationMessage);
        do {
            try {
                return bufferedReader.readLine();
            } catch (IOException e) {
                printMessage(String.format(PLEASE_REPEAT_ENTER, e.getClass().getName(), e.getMessage()));
            }
        } while (true);
    }

    public static Integer parseInt(String data) {
        Integer result;

        try {
            result = Integer.parseInt(data);

        } catch (NullPointerException | NumberFormatException e) {
            result = null;
        }

        return result;
    }

    public static long getNanoTime() {
        return System.nanoTime();
    }

    public static Long nanoToMicroTime(Long nanoTime) {
        return (nanoTime == null) ? null : (nanoTime / 1000);
    }

    public static String getApplicationMainClassName() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        StackTraceElement main = stack[stack.length - 1];

        return main.getClassName();
    }

    public static Class getApplicationMainClass() {
        Class result;

        try {
            result = Class.forName(getApplicationMainClassName());
        } catch (ClassNotFoundException e) {
            // Unfortunately, it is difficult to recognize what could be the reason of such situation, but
            // now try to get it from stack directly
            StackTraceElement[] stack = Thread.currentThread().getStackTrace();
            StackTraceElement main = stack[stack.length - 1];
            result = main.getClass();
        }

        return result;
    }

    public static void printMenu(Map<Integer, MenuItem> menu) {
        menu.forEach((c, i) -> printMessage(String.format(CODE_MENU_ITEM_PATTERN, c, i.getItemText())));
    }

    public static int chooseMenuItemCode(String invitationMessage, Map<Integer, MenuItem> menu, int exitCode) {
        Integer result;
        Set<Integer> availableCode = menu.keySet();

        do {
            printMenu(menu);
            result = parseInt(readInputString(invitationMessage));
            if (availableCode.contains(result)) {
                if (result == exitCode) {
                    break;
                } else {
                    menu.get(result).menuAction();
                }
            }
        } while (result == null || result != exitCode);

        return result;
    }

    private static String getLongestString(String[] data) {
        Optional<String> longest = Arrays.stream(data).max((f1, f2) ->
                new Integer((f1 == null) ? 0 : f1.length()).compareTo((f2 == null)? 0: f2.length()));

        return longest.isPresent() ? longest.get() : "";
    }

    public static int getLengthOfLongestString(String[] data) {
        String s = getLongestString(data);
        return s.length();
    }

    public static String[] convertColumnToStringArray (String[][] tableData, int columnNumber) {
        String[] result = new String[tableData.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = tableData[i][columnNumber];
        }

        return result;
    }

    public static void printTable(String[] table) {
        Arrays.stream(table).forEach(Util::printMessage);
    }
}