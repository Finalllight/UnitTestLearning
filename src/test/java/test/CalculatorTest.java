package test;
import org.example.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void testAdd() {
        // 正常情况测试
        assertEquals(5.0, Calculator.add(2.0, 3.0), 0.001);
        assertEquals(0.0, Calculator.add(-2.0, 2.0), 0.001);
        assertEquals(-5.0, Calculator.add(-2.0, -3.0), 0.001);
        assertEquals(10.5, Calculator.add(5.25, 5.25), 0.001);

        // 边界值测试
        assertEquals(0.0, Calculator.add(0.0, 0.0), 0.001);
        assertEquals(Double.MAX_VALUE, Calculator.add(Double.MAX_VALUE, 0.0), 0.001);
    }

    // 测试减法
    @Test
    public void testSubtract() {
        // 正常情况测试
        assertEquals(2.0, Calculator.subtract(5.0, 3.0), 0.001);
        assertEquals(-2.0, Calculator.subtract(3.0, 5.0), 0.001);
        assertEquals(0.0, Calculator.subtract(5.0, 5.0), 0.001);
        assertEquals(2.5, Calculator.subtract(5.5, 3.0), 0.001);

        // 边界值测试
        assertEquals(0.0, Calculator.subtract(0.0, 0.0), 0.001);
        assertEquals(-Double.MAX_VALUE, Calculator.subtract(0.0, Double.MAX_VALUE), 0.001);
    }

    // 测试乘法
    @Test
    public void testMultiply() {
        // 正常情况测试
        assertEquals(6.0, Calculator.multiply(2.0, 3.0), 0.001);
        assertEquals(-6.0, Calculator.multiply(2.0, -3.0), 0.001);
        assertEquals(0.0, Calculator.multiply(5.0, 0.0), 0.001);
        assertEquals(7.5, Calculator.multiply(2.5, 3.0), 0.001);

        // 边界值测试
        assertEquals(0.0, Calculator.multiply(0.0, 0.0), 0.001);
        assertEquals(1.0, Calculator.multiply(1.0, 1.0), 0.001);
    }

    // 测试除法
    @Test
    public void testDivide() {
        // 正常情况测试
        assertEquals(2.0, Calculator.divide(6.0, 3.0), 0.001);
        assertEquals(-2.0, Calculator.divide(6.0, -3.0), 0.001);
        assertEquals(2.5, Calculator.divide(5.0, 2.0), 0.001);
        assertEquals(0.5, Calculator.divide(1.0, 2.0), 0.001);

        // 测试除数为0的情况
        try {
            Calculator.divide(5.0, 0.0);
            fail("应该抛出ArithmeticException异常");
        } catch (ArithmeticException e) {
            assertEquals("除数不能为零", e.getMessage());
        }

        // 测试被除数为0的情况
        assertEquals(0.0, Calculator.divide(0.0, 5.0), 0.001);
    }

    // 综合测试 - 测试多个操作的组合
    @Test
    public void testCombinedOperations() {
        // (10 + 5) * 2 / 3 = 10
        double result1 = Calculator.multiply(Calculator.add(10, 5), 2);
        result1 = Calculator.divide(result1, 3);
        assertEquals(10.0, result1, 0.001);

        // (8 - 2) / 2 * 5 = 15
        double result2 = Calculator.divide(Calculator.subtract(8, 2), 2);
        result2 = Calculator.multiply(result2, 5);
        assertEquals(15.0, result2, 0.001);
    }
}