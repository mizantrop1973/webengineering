package org.doit;

import org.doit.MessageRenderer;
import org.doit.SimpleMessageProvider;
import org.doit.SimpleMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



public class JavaConfig {

    @Bean
    public MessageProvider provider(){
        return new SimpleMessageProvider();
    }

    @Bean
    public MessageRenderer renderer(@Autowired MessageProvider provider) {
        return new SimpleMessageRenderer(provider);
    }
}

