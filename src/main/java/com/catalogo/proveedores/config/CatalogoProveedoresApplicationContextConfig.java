package com.catalogo.proveedores.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@ComponentScan(
        basePackages = {
                "com.catalogo.proveedores.entities",
                "com.catalogo.proveedores.repositories",
                "com.catalogo.proveedores.services.impl",
                "com.catalogo.proveedores.controllers.impl"
        }
)
@EnableJpaRepositories(basePackages = {
        "com.catalogo.proveedores.repositories"
})
@EntityScan(basePackages = {
        "com.catalogo.proveedores.entities"
})
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class CatalogoProveedoresApplicationContextConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String urlDatabase;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(urlDatabase);
//        dataSource.setUsername(userName);
//        dataSource.setPassword(password);
//        return dataSource;
//    }

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driverClassName);
        config.setJdbcUrl(urlDatabase);
        config.setUsername(userName);
        config.setPassword(password);
        return new HikariDataSource(config);
    }

}
