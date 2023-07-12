package org.web3soft.commons.support.properties;

/**
 * 数据源配置项类
 *
 * @author web3soft-team
 */
public class DataSourceProperty {
    private String driverClassName = "com.alibaba.druid.pool.DruidDataSource";
    private String type = "com.mysql.jdbc.Driver";
    private String url;
    private String username;
    private String password;
    private int maxActive = 10;
    private int minIdle = 0;

    public String getDriverClassName() {
        return this.driverClassName;
    }

    public void setDriverClassName(final String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getType() {
        return this.type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public int getMaxActive() {
        return this.maxActive;
    }

    public void setMaxActive(final int maxActive) {
        this.maxActive = maxActive;
    }

    public int getMinIdle() {
        return this.minIdle;
    }

    public void setMinIdle(final int minIdle) {
        this.minIdle = minIdle;
    }
}
