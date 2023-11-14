package br.com.dermocosmeticos.appDermocosmeticos.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AplicationConfiguration {

    @Bean
    public ResultUtil resultUtil() {
        return new ResultUtil();
    }
}
