package com.myk.learning.multisource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * Open plat form data source configuration
 * <p/>
 * Created in 2018.10.29
 * <p/>
 *
 * @author myk
 */
@Configuration
@MapperScan(basemyks = {"com.myk.learning.multisource.mapper.test"}, sqlSessionFactoryRef = "testSqlSessionFactory")
public class TestDataSourceConfiguration {
    /**
     * The constant MAPPER_XML_LOCATION.
     */
    public static final String MAPPER_XML_LOCATION = "classpath:mapper/test/*.xml";

    /**
     * The Open plat form data source.
     */
    @Autowired
    @Qualifier("TestDataSource")
    DataSource testDataSource;

    /**
     * Open plat form sql session template sql session template.
     *
     * @return the sql session template
     * @throws Exception the exception
     */
    @Bean
    public SqlSessionTemplate testSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(testSqlSessionFactory());
    }

    /**
     * Open plat form sql session factory sql session factory.
     *
     * @return the sql session factory
     * @throws Exception the exception
     */
    @Bean
    public SqlSessionFactory testSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(testDataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_XML_LOCATION));
        return factoryBean.getObject();
    }
}
