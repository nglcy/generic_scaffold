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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @ClassName DataSourcesConfig
 * @Author chenyuan
 * @Description TODO
 * @Date 2019/10/20 17:42
 */
@Configuration
@MapperScan(basePackages = "com.chenyuan.dao.mapper.local", sqlSessionFactoryRef = "localSqlSessionFactory")

public class LocalDataSourcesConfig { // 将这个对象放入Spring容器中

    @Autowired
    private LocalDataProperties ldp;

    @Bean(name = "localDataSource")
    // 表示这个数据源是默认数据源
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.local")
    public DataSource getLocalDataSource() {
        DataSource build = DataSourceBuilder
                .create()
                .driverClassName(ldp.getDriverClassName())
                .password(ldp.getPassword())
                .url(ldp.getUrl())
                .username(ldp.getUsername()).build();
        return build;
    }


    @Bean(name = "localSqlSessionFactory")
    // 表示这个数据源是默认数据源
    @Primary
    // @Qualifier表示查找Spring容器中名字为test1DataSource的对象
    public SqlSessionFactory test1SqlSessionFactory(@Qualifier("localDataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                // 设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/local/*.xml"));
        return bean.getObject();
    }

    @Bean("localSqlSessionTemplate")
    // 表示这个数据源是默认数据源
    @Primary
    public SqlSessionTemplate localsqlsessiontemplate(
            @Qualifier("localSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
}