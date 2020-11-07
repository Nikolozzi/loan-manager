package com.gmail.khitirinikoloz.loanmanager.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebMvcConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
