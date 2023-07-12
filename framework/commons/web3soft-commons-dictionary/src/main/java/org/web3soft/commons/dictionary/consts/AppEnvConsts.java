package org.web3soft.commons.dictionary.consts;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

/**
 * 应用环境常量
 *
 * @author web3soft-team
 **/
public class AppEnvConsts {
    /**
     * http context 路径境配置项
     */
    public final static String CONTEXT_PATH = "ctxPath";

    /**
     * 系统运行环境配置项
     */
    public final static String ENV_NAME_ITEM = "env";

    /**
     * 应用名称配置项
     */
    public final static String APP_NAME_ITEM = "appName";

    /**
     * 应用服务的网站主域名配置项
     */
    public final static String DOMAIN_ITEM = "domain";

    /**
     * 系统统一版本名称境配置项
     */
    public final static String VERSION_ITEM = "version";

    /**
     * 系统版本随机数配置项
     */
    public final static String RANDOM_ITEM = "rnd";

    /**
     * 系统应用名称
     */
    public static String APP_NAME = "Default";

    /**
     * 设置系统应用服务的网站主域名
     */
    public static String DOMAIN = "www.web3soft.org";

    /**
     * 系统统一版本名称境配置项默认值
     */
    public static String VERSION = "2.0";

    /**
     * 系统运行环境配置项默认值
     */
    public static String ENV_NAME = "prod";

    /**
     * 系统版本随机数配置项默认值
     */
    public static float RANDOM = 0.0f;

    /**
     * 系统默认语言项默认值（简体中文）
     */
    public static Locale DEFAULT_LOCALE = Locale.SIMPLIFIED_CHINESE;


    /**
     * 设置系统应用名称
     *
     * @param appName 默认为app.name配置项的值
     */
    public static void setAppName(final String appName) {
        AppEnvConsts.APP_NAME = appName;
    }

    /**
     * 设置应用发布版本
     *
     * @param version
     */
    public static void setVersion(final String version) {
        AppEnvConsts.VERSION = version;
    }

    /**
     * 设置应用部署环境名，取值范围为[dev,test,pre,test]
     *
     * @param envName
     */
    public static void setEnvName(final String envName) {
        AppEnvConsts.ENV_NAME = envName;
    }

    /**
     * 设置系统应用服务的网站主域名
     *
     * @param domain 默认为配置项的值
     */
    public static void setDomain(final String domain) {
        AppEnvConsts.DOMAIN = domain;
    }

    /**
     * 系统版本随机数配置项值
     *
     * @param rnd 随机数
     */
    public static void setRandom(final float rnd) {
        AppEnvConsts.RANDOM = rnd;
    }

    /**
     * 应用部署环境名是否为生产环境
     *
     * @return true|false
     */
    public static boolean isProductionMode() {
        return StringUtils.equalsAnyIgnoreCase(AppEnvConsts.ENV_NAME, "prod");
    }

    /**
     * 应用部署环境名是否为预发环境
     *
     * @return true|false
     */
    public static boolean isStagingMode() {
        return StringUtils.equalsAnyIgnoreCase(AppEnvConsts.ENV_NAME, "stag");
    }

    /**
     * 应用部署环境名是否为测试环境
     *
     * @return true|false
     */
    public static boolean isTestMode() {
        return StringUtils.equalsAnyIgnoreCase(AppEnvConsts.ENV_NAME, "test");
    }

    /**
     * 应用部署环境名是否为日常环境
     *
     * @return true|false
     */
    public static boolean isDailyMode() {
        return StringUtils.equalsAnyIgnoreCase(AppEnvConsts.ENV_NAME, "daily");
    }

    /**
     * 应用部署环境名是否为开发环境
     *
     * @return true|false
     */
    public static boolean isDevelopmentMode() {
        return StringUtils.equalsAnyIgnoreCase(AppEnvConsts.ENV_NAME, "dev");
    }

    /**
     * 系统默认语言项默认值（简体中文）
     *
     * @return {@link Locale}
     */
    public static Locale setDefaultLocale(final Locale locale) {
        return AppEnvConsts.DEFAULT_LOCALE = locale;
    }
}
