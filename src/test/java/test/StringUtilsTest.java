package test;
import org.example.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    // 测试reverse方法
    @Test
    void reverse_shouldReturnReversedString() {
        // 正常情况
        assertEquals("cba", StringUtils.reverse("abc"));
        assertEquals("!edcba", StringUtils.reverse("abcde!"));

        // 空字符串
        assertEquals("", StringUtils.reverse(""));

        // 单字符
        assertEquals("a", StringUtils.reverse("a"));

        // null值
        assertNull(StringUtils.reverse(null));
    }

    // 测试isPalindrome方法，使用参数化测试
    @ParameterizedTest
    @ValueSource(strings = {
            "madam",      // 正常回文
            "RaceCar",    // 大小写不同的回文
            "",           // 空字符串
            "a"           // 单字符
    })
    void isPalindrome_shouldReturnTrueForPalindromes(String input) {
        assertTrue(StringUtils.isPalindrome(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "hello",      // 非回文
            "test",       // 非回文
    })
    void isPalindrome_shouldReturnFalseForNonPalindromes(String input) {
        assertFalse(StringUtils.isPalindrome(input));
    }

    // 测试countVowels方法，使用CSV参数化测试
    @ParameterizedTest
    @CsvSource({
            "Hello, 2",    // 正常情况
            "AEIOU, 5",    // 大写元音
            "xyz, 0",      // 无元音
            ", 0",         // 空字符串
            "null, 0"      // 包含"null"字符串而非null值
    })
    void countVowels_shouldReturnCorrectCount(String input, int expected) {
        assertEquals(expected, StringUtils.countVowels(input));
    }

    @Test
    void countVowels_shouldReturn0ForNull() {
        assertEquals(0, StringUtils.countVowels(null));
    }

    // 测试capitalize方法
    @Test
    void capitalize_shouldCapitalizeFirstLetter() {
        // 正常情况
        assertEquals("Hello", StringUtils.capitalize("hello"));
        assertEquals("Hello", StringUtils.capitalize("HELLO"));

        // 空字符串
        assertEquals("", StringUtils.capitalize(""));

        // 单字符
        assertEquals("A", StringUtils.capitalize("a"));
        assertEquals("B", StringUtils.capitalize("B"));

        // null值
        assertNull(StringUtils.capitalize(null));
    }

    // 测试truncate方法
    @Test
    void truncate_shouldTruncateLongStrings() {
        // 超过最大长度
        assertEquals("abc...", StringUtils.truncate("abcdef", 3));

        // 等于最大长度
        assertEquals("abc", StringUtils.truncate("abc", 3));

        // 小于最大长度
        assertEquals("ab", StringUtils.truncate("ab", 3));

        // null值
        assertNull(StringUtils.truncate(null, 5));
    }

    @Test
    void truncate_shouldThrowExceptionForInvalidMaxLength() {
        // 测试异常情况，包括0和负数
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> StringUtils.truncate("test", 0)),
                () -> assertThrows(IllegalArgumentException.class, () -> StringUtils.truncate("test", -5)),
                () -> assertThrows(IllegalArgumentException.class, () -> StringUtils.truncate(null, -1))
        );
    }
}