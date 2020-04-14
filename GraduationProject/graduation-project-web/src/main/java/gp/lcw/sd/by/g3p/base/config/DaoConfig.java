package gp.lcw.sd.by.g3p.base.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DaoConfig {


    @Bean
    public DataSource datasource (Environment env) {


        System.out.println("数据库配置类1");
        HikariDataSource ds =new HikariDataSource();
        System.out.println("数据库配置类2");
        ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
        System.out.println("数据库配置类3");
        ds.setUsername(env.getProperty("spring.datasource.username"));
        System.out.println("数据库配置类4");
        ds.setPassword(env.getProperty("spring.datasource.password"));
        System.out.println("数据库配置类5");
        ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        System.out.println("数据库配置类6");

        return  ds;

    }
}
