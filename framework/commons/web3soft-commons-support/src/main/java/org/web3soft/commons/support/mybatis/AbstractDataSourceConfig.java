package org.web3soft.commons.support.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author web3soft-team
 **/
public abstract class AbstractDataSourceConfig {
    protected static final String CONFIG_LOCATION = "classpath:mybatis/mybatis-config.xml";

    protected DataSourceTransactionManager createTransactionManager(final DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    protected SqlSessionFactory createSqlSessionFactory(final DataSource dataSource, final String mapperLocation)
            throws Exception {
        return this.createSqlSessionFactory(dataSource, new String[]{mapperLocation});
    }

    protected SqlSessionFactory createSqlSessionFactory(final DataSource dataSource, final String[] mapperLocations)
            throws Exception {
        return this.createSqlSessionFactoryBean(dataSource, mapperLocations).getObject();
    }

    protected SqlSessionFactoryBean createSqlSessionFactoryBean(final DataSource dataSource,
                                                                final String mapperLocation) throws Exception {
        return this.createSqlSessionFactoryBean(dataSource, new String[]{mapperLocation});
    }

    protected SqlSessionFactoryBean createSqlSessionFactoryBean(final DataSource dataSource,
                                                                final String[] mapperLocations) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(AbstractDataSourceConfig.CONFIG_LOCATION));
        sessionFactory.setMapperLocations(this.resolveMapperLocations(mapperLocations));
        return sessionFactory;
    }

    protected SqlSessionTemplate createSqlSessionTemplate(final SqlSessionFactory sqlSessionFactory) throws
            Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    protected TransactionTemplate createTransactionTemplate(final DataSourceTransactionManager transactionManager)
            throws Exception {
        return new TransactionTemplate(transactionManager);
    }

    protected Resource[] resolveMapperLocations(final String[] mapperLocations) {
        final ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        final List<Resource> resources = new ArrayList<>();
        if (mapperLocations != null) {
            for (final String mapperLocation : mapperLocations) {
                try {
                    final Resource[] mappers = resourceResolver.getResources(mapperLocation);
                    resources.addAll(Arrays.asList(mappers));
                } catch (final IOException e) {
                    // ignore
                }
            }
        }
        return resources.toArray(new Resource[0]);
    }
}
