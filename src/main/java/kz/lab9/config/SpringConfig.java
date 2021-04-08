package kz.lab9.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "kz.lab9")
@PropertySource("application.properties")
@EnableJpaRepositories(basePackages = "kz.lab9.repositories")
public class SpringConfig {
}
