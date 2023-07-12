package org.web3soft.commons.lang.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author web3soft-team
 **/
@Slf4j
public class StringUtil {
    public static final char UNDERLINE = '_';
    public static final char DASH = '-';
    private static final Pattern IP_PATTERN = Pattern.compile(
            "(((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|"
                    + "(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|([1-9]\\d)|(\\d))[.](((2[0-4]\\d)|(25[0-5]))|(1\\d{2})|"
                    + "([1-9]\\d)|(\\d))");
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^([a-zA-Z0-9_\\-\\.\\+]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))"
                    + "([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
    private static final Pattern MOBILE_PATTERN = Pattern.compile(
            "^((0031[0-9])|(11[0-9])|(12[0-9])|(13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$");

    /**
     * 把'_'变成'-' (foo_boo -> foo-boo)
     *
     * @param str string
     * @return (foo_boo - > foo - boo)
     */
    public static String underlineToDash(final String str) {
        return StringUtils.replaceChars(str, UNDERLINE, DASH);
    }

    /**
     * 把'-'变成'_' (foo-boo -> foo_boo)
     *
     * @param str string
     * @return (foo - boo - > foo_boo)
     */
    public static String dashToUnderline(final String str) {
        return StringUtils.replaceChars(str, DASH, UNDERLINE);
    }

    /**
     * ip校验
     *
     * @param ip ip address
     * @return 格式是否正确
     */
    public static boolean isIpAddress(final String ip) {
        return IP_PATTERN.matcher(ip).matches();
    }

    /**
     * email校验
     *
     * @param email Email address
     * @return 格式是否正确
     */
    public static boolean isEmail(final String email) {
        if (StringUtils.isEmpty(email)) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * 手机号校验
     *
     * @param phone mobile phone number
     * @return 格式是否正确
     */
    public static boolean isMobile(final String phone) {
        if (StringUtils.isEmpty(phone)) {
            return false;
        }
        return MOBILE_PATTERN.matcher(phone).matches();
    }

    /**
     * 是否为允许的图片文件扩展名
     *
     * @param fileName 文件名
     * @return true|false
     */
    public static boolean isAllowedImageFileExtension(final String fileName) {
        final String[] extensions = {".jpg", ".jpeg", ".png", ".bmp"};
        return isAllowedFileExtension(fileName, extensions);
    }

    /**
     * 是否为允许的文件扩展名
     *
     * @param fileName 文件名
     * @return true|false
     */
    public static boolean isAllowedFileExtension(final String fileName) {
        final String[] extensions = {".jpg", ".jpeg", ".png", ".pdf", ".gif", ".bmp"};
        return isAllowedFileExtension(fileName, extensions);
    }

    /**
     * 是否为允许的文件扩展名
     *
     * @param fileName   文件名
     * @param extensions 允许的文件扩展名集合
     * @return true|false
     */
    public static boolean isAllowedFileExtension(final String fileName, final String[] extensions) {
        if (StringUtils.isBlank(fileName)) {
            return false;
        }
        return StringUtils.endsWithAny(fileName.toLowerCase(), extensions);
    }

    /**
     * 是否为不允许的文件扩展名
     *
     * @param fileName 文件名
     * @return true|false
     */
    public static boolean isNotAllowedFileExtension(final String fileName) {
        return !isAllowedFileExtension(fileName);
    }

    /**
     * 是否为不允许的图片文件扩展名
     *
     * @param fileName 文件名
     * @return true|false
     */
    public static boolean isNotAllowedImageFileExtension(final String fileName) {
        return !isAllowedImageFileExtension(fileName);
    }

    /**
     * 是否为不允许的文件扩展名
     *
     * @param fileName   文件名
     * @param extensions 允许的文件扩展名集合
     * @return true|false
     */
    public static boolean isNotAllowedFileExtension(final String fileName, final String[] extensions) {
        return !isAllowedFileExtension(fileName, extensions);
    }

    /**
     * @param str1
     * @param str2
     * @return true｜false
     */
    public static boolean notEqualsIgnoreCase(final String str1, final String str2) {
        return !StringUtils.equalsIgnoreCase(str1, str2);
    }

    /**
     * @param str1
     * @param str2
     * @return true｜false
     */
    public static boolean notEquals(final String str1, final String str2) {
        return !StringUtils.equals(str1, str2);
    }

    /**
     * @param str1
     * @param str2
     * @return true｜false
     */
    public static boolean notEqualsIgnoreCaseWithTrim(final String str1, final String str2) {
        return notEqualsIgnoreCase(StringUtils.trim(str1), StringUtils.trim(str2));
    }

    /**
     * @param str1
     * @param str2
     * @return true｜false
     */
    public static boolean notEqualsWithTrim(final String str1, final String str2) {
        return notEquals(StringUtils.trim(str1), StringUtils.trim(str2));
    }

    /**
     * 从url中获得host
     *
     * @param url url
     * @return domain
     */
    public static String getDomain(final String url) {
        final String regEx = "(https?://[^/]+)/.*";
        final Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static String[] splitSymbol(final String symbol) {
        return StringUtils.split(symbol, "_");
    }

    public static String starString(final String content) {
        if (isEmail(content)) {
            return getStarString(content, 3, content.indexOf('@'));
        }
        return getStarMobile(content);
    }

    /**
     * 对字符串处理:将指定位置到指定位置的字符以星号代替
     *
     * @param content 传入的字符串
     * @param start   开始位置
     * @param end     结束位置(不包括）
     * @return star String
     */
    public static String getStarString(final String content, final int start, final int end) {
        if (StringUtils.isBlank(content)) {
            return StringUtils.EMPTY;
        }

        final boolean check = ((start >= content.length() || start < 0)
                || (end >= content.length() || end < 0)
                || (start >= end)
        );

        if (check) {
            return content;
        }

        final String stars = StringUtils.repeat('*', end - start);
        return content.substring(0, start) + stars + content.substring(end);
    }

    /**
     * 对真实姓名加星号处理
     *
     * @param content 真实姓名
     * @return star String
     */
    public static String getStarRealName(final String content) {
        if (StringUtils.isBlank(content)) {
            return content;
        }
        if (content.length() == 2) {
            return content.charAt(0) + "*";
        }
        return getStarString(content, 1, content.length() - 1);
    }

    /**
     * 对手机号加星号处理
     *
     * @param phone 手机号
     * @return star String
     */
    public static String getStarMobile(final String phone) {
        return getStarString(phone, 3, 7);
    }

    /**
     * 按位取值，返回指定位的值<br>
     *
     * @param value 原值
     * @param bit   指定位序号，从1开始
     * @return bit index
     */
    public static int getBinaryIndex(final Long value, final int bit) {
        return (int) (value >> (bit - 1) & 1);
    }

    /**
     * 对手机号加星号处理
     *
     * @param email 邮箱地址
     * @return star String
     */
    public static String getStarEmail(final String email) {
        if (StringUtils.isBlank(email) || !isEmail(email)) {
            return StringUtils.defaultIfBlank(email, StringUtils.EMPTY);
        }
        final int maxStarNum = 4;
        final String atCh = "@";
        final String emailPrefix = email.substring(0, email.indexOf(atCh));
        final int endIndex = emailPrefix.length() - maxStarNum;
        final int length = (endIndex <= 0) ? 1 : endIndex;
        final int starNum = (endIndex <= 0) ? emailPrefix.length() - 1 : maxStarNum;
        return email.substring(0, length) + StringUtils.repeat('*', starNum) + email.substring(email.indexOf("@"));
    }

    /**
     * 根据scale的值动态格式化并截取double类型数据
     *
     * @param value double数据
     * @param scale 精度位数(保留的小数位数)
     * @return 格式化后的数据
     */
    public static String doubleFormatCommonCut(final double value, final int scale) {
        final String formatValue = DoubleUtil.format(value, scale);
        return formatValue.replaceAll("0+?$", "").replaceAll("[.]$", "");
    }
}
