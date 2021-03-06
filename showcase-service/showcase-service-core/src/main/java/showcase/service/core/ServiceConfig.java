package showcase.service.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import showcase.addressresolver.AddressResolverConfig;
import showcase.common.cache.CachingConfig;
import showcase.common.logging.AutoLoggerConfig;
import showcase.persistence.repository.RepositoryConfig;

@Configuration
@ComponentScan(basePackageClasses = ServiceConfig.class)
@Import({RepositoryConfig.class, AddressResolverConfig.class, CachingConfig.class, AutoLoggerConfig.class})
@EnableAspectJAutoProxy
public class ServiceConfig {

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

}
