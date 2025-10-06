package org.example;

/**
 * 字符串工具类，提供常见的字符串处理功能
 */
public class StringUtils {

    /**
     * 反转字符串
     * @param str 要反转的字符串，可为null
     * @return 反转后的字符串，如果输入为null则返回null
     */
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        char[] chars = str.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[n - 1 - i];
            chars[n - 1 - i] = temp;
        }
        return new String(chars);
    }

    /**
     * 检查字符串是否为回文（忽略大小写）
     * @param str 要检查的字符串，可为null
     * @return 如果是回文返回true，否则返回false；null返回false
     */
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }

    /**
     * 计算字符串中元音字母的数量（a, e, i, o, u，忽略大小写）
     * @param str 要计算的字符串，可为null
     * @return 元音字母的数量，如果输入为null返回0
     */
    public static int countVowels(String str) {
        if (str == null || str.isEmpty()|| str.equals("null")) {
            return 0;
        }
        int count = 0;
        String lowerStr = str.toLowerCase();
        for (int i = 0; i < lowerStr.length(); i++) {
            char c = lowerStr.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    /**
     * 将字符串的首字母大写，其余字母小写
     * @param str 要处理的字符串，可为null或空
     * @return 首字母大写的字符串，如果输入为null或空则返回原字符串
     */
    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        if (str.length() == 1) {
            return str.toUpperCase();
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    /**
     * 将字符串截断到指定长度，如果长度超过则添加省略号"..."
     * @param str 要截断的字符串，可为null
     * @param maxLength 最大长度，必须大于0，否则抛出IllegalArgumentException
     * @return 处理后的字符串
     */
    public static String truncate(String str, int maxLength) {
        if (maxLength <= 0) {
            throw new IllegalArgumentException("最大长度必须大于0");
        }
        if (str == null) {
            return null;
        }
        if (str.length() <= maxLength) {
            return str;
        }
        return str.substring(0, maxLength) + "...";
    }
}
