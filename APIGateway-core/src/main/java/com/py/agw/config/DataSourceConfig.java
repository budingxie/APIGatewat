package com.py.agw.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.WebStatFilter;
import org.eclipse.jetty.servlet.StatisticsServlet;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * description：数据源配置
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/13
 */
@Configuration
@MapperScan(basePackages = {"com.py.agw.dao.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory")
@EnableTransactionManagement
public class DataSourceConfig {

    @Value(value = "classpath:mybatis/mybatis-config.xml")
    private Resource configLocation;

    @Value("classpath:mybatis/mappers/com/py/agw/dao/mapper/*.xml")
    private Resource[] mapperLocations;

    private static final String typeAliasesPackage = "com.py.agw.dao.model";

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(configLocation);
        sqlSessionFactoryBean.setMapperLocations(mapperLocations);
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    /**
     * druid的监控管理后台
     *
     * @return
     */
    public ServletRegistrationBean<StatisticsServlet> statViewServlet() {
        ServletRegistrationBean<StatisticsServlet> servletRegistrationBean
                = new ServletRegistrationBean<>(new StatisticsServlet(), "/druid/*");
        Map<String, String> initParams = new HashMap<>(8);

        // 用户名、密码
        initParams.put("loginUsername", "admin");
        initParams.put("loginPassword", "admin");

        // ip白名单
        initParams.put("allow", "");

        // 是否能重置数据
        initParams.put("resetEnable", "false");

        servletRegistrationBean.setInitParameters(initParams);
        return servletRegistrationBean;
    }

    /**
     * druid的服务过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(new WebStatFilter());

        Map<String, String> initParams = new HashMap<>(4);
        // 忽略过滤的格式
        initParams.put("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        filterRegistrationBean.setInitParameters(initParams);

        // 过滤规则
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));

        return filterRegistrationBean;
    }
}
