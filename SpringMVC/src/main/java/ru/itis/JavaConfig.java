package ru.itis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("ru.itis")
public class JavaConfig {
    /*@Bean
    public MessageProvider provider() {
        return new SimpleMessageProvider();
    }
    @Bean
    public MessageRenderer renderer(@Autowired MessageProvider provider) {
        return new SimpleMessageRenderer(provider);
    }*/
}
