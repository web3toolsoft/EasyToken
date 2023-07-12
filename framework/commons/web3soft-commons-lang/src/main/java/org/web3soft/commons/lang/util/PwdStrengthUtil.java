package org.web3soft.commons.lang.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 密码强度工具类
 * -1:密码为null或空字符
 * 0 :密码长度不是6-20位
 * 1 :一种模式（纯小写字母、纯大写字母，纯数字，纯特殊字符）
 * 2 :两种模式
 * 3 :三种模式
 * 4 :四种模式
 */
public class PwdStrengthUtil {
    public final static String LOWEST = "lowest";
    public final static String MIDDLE = "middle";
    public final static String HIGHEST = "highest";

    /**
     * 返回密码的强度级别
     *
     * @param password
     * @return lowest|middle|highest
     */
    public static String getStrengthLevelName(final String password) {
        return getStrengthLevelName(getStrengthLevel(password));
    }


    /**
     * 返回密码的强度级别
     *
     * @param level [-1,0,1,2,3,4]
     * @return lowest|middle|highest
     */
    public static String getStrengthLevelName(final int level) {
        if (level <= 1) {
            return LOWEST;
        }
        if (level <= 3) {
            return MIDDLE;
        }
        return HIGHEST;
    }

    /**
     * 返回密码的强度级别
     *
     * @param password
     * @return [-1,0,1,2,3,4]之一
     */
    public static int getStrengthLevel(final String password) {
        if (StringUtils.isBlank(password)) {
            return -1;
        }

        //密码太短或太长
        if (password.length() < 6 || password.length() > 20) {
            return 0;
        }

        int modes = 0;
        for (int i = 0; i < password.length(); i++) {
            //测试每一个字符的类别并统计一共有多少种模式.
            modes |= charMode(password.charAt(i));
        }
        return bitTotal(modes);
    }

    /**
     * charMode
     *
     * @param ch ASSIC码值
     * @return 测试某个字符是属于哪一类.
     */
    private static int charMode(final int ch) {
        //数字
        if (ch >= 48 && ch <= 57) {
            return 1;
        }
        //大写字母
        if (ch >= 65 && ch <= 90) {
            return 2;
        }
        //小写字线
        if (ch >= 97 && ch <= 122) {
            return 4;
        } else {
            //特殊字符
            return 8;
        }
    }

    /**
     * 计算出当前密码当中一共有多少种模式
     *
     * @param num
     * @return
     */
    private static int bitTotal(int num) {
        int modes = 0;
        for (int i = 0; i < 4; i++) {
            if (num % 2 == 1) {
                modes++;
            }
            num >>>= 1;
        }
        return modes;
    }
}
