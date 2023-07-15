package org.web3soft.spring.boot.autoconfigure.env;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author web3soft-team
 */
@ConfigurationProperties(prefix = "web3soft.app")
public class AppEnvProperties {
    private String name = "";
    private String version = "1.0";
    private String domain = "web3soft.org";
    private Env env = new Env();

    /**
     * 获取应用名称
     *
     * @return 应用名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置应用名称
     *
     * @param name 应用名称
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * 获取应用版本
     *
     * @return 版本
     */
    public String getVersion() {
        return this.version;
    }

    /**
     * 设置应用版本
     *
     * @param version 版本
     */
    public void setVersion(final String version) {
        this.version = version;
    }

    /**
     * 获取应用当前运行的站点域名(web3soft.org等）
     *
     * @return web3soft.org
     */
    public String getDomain() {
        return this.domain;
    }

    /**
     * 设置应用当前运行的站点域名(web3soft.org等）
     *
     * @param domain (web3soft.org等）
     */
    public void setDomain(final String domain) {
        this.domain = domain;
    }

    /**
     * 获取应用当前运行的相关环境属性
     *
     * @return 环境属性对象
     */
    public Env getEnv() {
        return this.env;
    }

    /**
     * 设置应用当前运行的相关环境属性
     *
     * @param env 环境属性对象
     */
    public void setEnv(final Env env) {
        this.env = env;
    }

    public static class Env {
        private String name = "prod";
        private String defaultLocale = "zh-CN";

        /**
         * 获取应用环境名称[dev,test,stag,prod]
         *
         * @return 环境名称[dev, test, stag, prod]
         */
        public String getName() {
            return this.name;
        }

        /**
         * 设置应用环境名称[dev,test,pre,prod]
         *
         * @param name 应用环境名称[dev,test,pre,prod]
         */
        public void setName(final String name) {
            this.name = name;
        }

        /**
         * 获取系统默认语言(zh-CN,en-US,zh-TW等)
         *
         * @return (zh - CN, en - US, zh - TW等)
         */
        public String getDefaultLocale() {
            return this.defaultLocale;
        }

        /**
         * 设置系统默认语言 (zh-CN,en-US,zh-TW等)
         *
         * @param defaultLocale (zh-CN,en-US,zh-TW等)
         */
        public void setDefaultLocale(final String defaultLocale) {
            this.defaultLocale = defaultLocale;
        }
    }
}
