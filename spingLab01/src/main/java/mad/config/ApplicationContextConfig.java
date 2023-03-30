package mad.config;

import mad.Iphone;
import mad.Samsung;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationContextConfig {

    @Bean
    public Samsung samsung() {
        return new Samsung();
    }

    @Bean
    public Iphone iphone() {
        return new Iphone();
    }

}
