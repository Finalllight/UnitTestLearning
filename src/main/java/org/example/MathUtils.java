package org.example;

/**
 * 数学工具类，包含素数判断、最大公约数计算、斐波那契数列生成等功能
 */
public class MathUtils {

    /**
     * 判断一个数是否为素数（只能被1和自身整除的大于1的整数）
     * @param num 待判断的数字
     * @return 如果是素数返回true，否则返回false（负数、0、1均返回false）
     */
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        // 检查到平方根即可，减少计算量
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算两个非负整数的最大公约数（GCD），使用欧几里得算法
     * @param a 非负整数
     * @param b 非负整数
     * @return 最大公约数（如果a和b都为0，返回0）
     * @throws IllegalArgumentException 如果输入为负数
     */
    public static int gcd(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("输入必须为非负整数");
        }
        // 欧几里得算法：gcd(a,b) = gcd(b,a%b)，直到b为0
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    /**
     * 计算非负整数的阶乘（n!）
     * 定义：0! = 1，n! = n × (n-1) × ... × 1（n>0）
     * @param n 非负整数（n ≥ 0）
     * @return 阶乘结果（n!）
     * @throws IllegalArgumentException 当n为负数时抛出
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("阶乘的参数n不能为负数");
        }
        if (n == 0) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
