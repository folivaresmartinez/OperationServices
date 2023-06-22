package demo.olivares.config;

import io.corp.calculator.TracerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public TracerImpl tracerImpl() {
        return new TracerImpl();
    }
}