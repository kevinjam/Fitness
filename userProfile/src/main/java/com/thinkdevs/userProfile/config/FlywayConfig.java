package com.thinkdevs.userProfile.config;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class FlywayConfig {

    private final DataSource dataSource;

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        Flyway flyway = Flyway.configure()
                .baselineOnMigrate(true)
                .dataSource(dataSource)
                .locations("classpath:/db/migration")
                .outOfOrder(true)
                .baselineDescription("user")
                .installedBy("Kevin Janvier Chinabalire")
                .load();
        flyway.repair();
        return flyway;
    }

}