package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.example.MathUtils;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    // ------------------------------ 测试 isPrime 方法 ------------------------------
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17})
    @DisplayName("判断素数：输入素数应返回true")
    void isPrime_primeNumbers_returnsTrue(int num) {
        assertTrue(MathUtils.isPrime(num), num + "是素数，但测试未识别");
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 0, 1, 4, 6, 8, 9, 10})
    @DisplayName("判断素数：输入非素数应返回false")
    void isPrime_nonPrimeNumbers_returnsFalse(int num) {
        assertFalse(MathUtils.isPrime(num), num + "不是素数，但测试误判为素数");
    }

    // ------------------------------ 测试 gcd 方法 ------------------------------
    @ParameterizedTest
    @CsvSource({
            "8, 12, 4",    // 普通情况
            "0, 0, 0",     // 两数均为0
            "0, 5, 5",     // 其中一个数为0
            "17, 5, 1",    // 互质情况
            "25, 15, 5"    // 倍数关系
    })
    @DisplayName("计算最大公约数：正常输入返回正确结果")
    void gcd_validInputs_returnsCorrectGcd(int a, int b, int expected) {
        assertEquals(expected, MathUtils.gcd(a, b),
                "计算" + a + "和" + b + "的最大公约数错误");
    }

    @ParameterizedTest
    @CsvSource({"-1, 5", "3, -2", "-4, -6"})
    @DisplayName("计算最大公约数：输入负数应抛出异常")
    void gcd_negativeInputs_throwsException(int a, int b) {
        // 断言：调用gcd时会抛出IllegalArgumentException，且消息正确
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> MathUtils.gcd(a, b),
                "输入负数时未抛出异常"
        );
        assertEquals("输入必须为非负整数", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 1",    // 0的阶乘是1（数学定义）
            "1, 1",    // 1的阶乘是1
            "2, 2",    // 2! = 2
            "3, 6",    // 3! = 6
            "5, 120",  // 5! = 120
            "10, 3628800"  // 10! = 3628800
    })
    @DisplayName("计算正常非负整数的阶乘：返回正确结果")
    void factorial_validInputs_returnsCorrectResult(int n, long expected) {
        long result = MathUtils.factorial(n);
        assertEquals(expected, result, n + "的阶乘计算错误");
    }

    // ------------------------------ 测试异常输入场景 ------------------------------
    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -10})  // 负数参数
    @DisplayName("计算负数的阶乘：抛出IllegalArgumentException")
    void factorial_negativeInputs_throwsException(int n) {
        // 断言：调用factorial时会抛出预期异常，且异常消息正确
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> MathUtils.factorial(n),
                n + "是负数，应抛出异常但未抛出"
        );
        assertEquals("阶乘的参数n不能为负数", exception.getMessage());
    }

    // ------------------------------ 测试较大数值（验证逻辑正确性） ------------------------------
    @Test
    @DisplayName("计算较大数的阶乘（15!）：返回正确结果")
    void factorial_largeNumber_returnsCorrectResult() {
        // 15! = 1307674368000
        long result = MathUtils.factorial(15);
        assertEquals(1307674368000L, result, "15的阶乘计算错误");
    }

}