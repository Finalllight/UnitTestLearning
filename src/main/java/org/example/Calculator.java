package org.example;

// 计算器类
public class Calculator {

    // 加法
    public static double add(double a, double b) {
        return a + b;
    }

    // 减法
    public static double subtract(double a, double b) {
        return a - b;
    }

    // 乘法
    public static double multiply(double a, double b) {
        return a * b;
    }

    // 除法
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("除数不能为零");
        }
        return a / b;
    }
}