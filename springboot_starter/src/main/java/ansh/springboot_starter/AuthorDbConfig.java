package ansh.springboot_starter;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(basePackages = {"ansh.springboot_starter.RepositoriesAuthor"},
        entityManagerFactoryRef="getAuthorEm",
        transactionManagerRef="authorTxnManager")
public class AuthorDbConfig {

        @Bean
        @ConfigurationProperties(
                prefix = "author.datasource"
        )
        public DataSource getAuthorDs(){
            return DataSourceBuilder.create().build();
        }

        @Bean
        public LocalContainerEntityManagerFactoryBean getAuthorEm(){
            LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
            em.setDataSource(getAuthorDs());
            em.setPackagesToScan("ansh.springboot_starter.RepositoriesAuthor");

            Map<String, Object> properties = new HashMap<>();
            properties.put("hibernate.hbm2ddl.auto", "update");
            properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

            HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
            em.setJpaVendorAdapter(hibernateJpaVendorAdapter);
            em.setJpaPropertyMap(properties);
            return em;
        }

        @Bean
        public PlatformTransactionManager authorTxnManager(){
            JpaTransactionManager txnManager = new JpaTransactionManager();
            txnManager.setEntityManagerFactory(getAuthorEm().getObject());
            return txnManager;

        }



}
