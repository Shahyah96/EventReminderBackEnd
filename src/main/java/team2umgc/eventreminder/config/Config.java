package team2umgc.eventreminder.config;

import jakarta.validation.Validator;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
@EnableCaching
public class Config implements WebMvcConfigurer {

    @Bean
    ModelMapper constructModelMapper() {
        final ModelMapper modelMapper = new ModelMapper();
        final org.modelmapper.config.Configuration configuration = modelMapper.getConfiguration();
        configuration.setSkipNullEnabled(true);
        configuration.setPropertyCondition(Conditions.isNotNull());
        return modelMapper;
    }

    @Bean
    public Validator defaultValidator() {
        return new LocalValidatorFactoryBean();
    }
}
