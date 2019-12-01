package com.chenyuan.server.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @ClassName DateSourcesConfig
 * @Author chenyuan
 * @Description TODO
 * @Date 2019/10/20 17:42
 */
@Configuration
@MapperScan(basePackages = "com.chenyuan.dao.mapper.txyun", sqlSessionFactoryRef = "txyunSqlSessionFactory")
public class TXYunDataSourcesConfig {
    @Autowired
    private TXYunDataProperties tdp;

    @Bean(name = "txyunDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.txyun")
    public DataSource getTXYunDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(tdp.getDriverClassName())
                .password(tdp.getPassword())
                .url(tdp.getUrl())
                .username(tdp.getUsername())
                .build();
    }

    @Bean(name = "txyunSqlSessionFactory")
    public SqlSessionFactory test2SqlSessionFactory(@Qualifier("txyunDataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/txyun/*.xml"));
        return bean.getObject();
    }

    @Bean("txyunSqlSessionTemplate")
    public SqlSessionTemplate test2sqlsessiontemplate(
            @Qualifier("txyunSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
    @Bean("txyunTransactionManager")
    public PlatformTransactionManager getLocalTransactionManager(@Qualifier("txyunDataSource") DataSource dataSource){
        return  new DataSourceTransactionManager(dataSource);
    }
}