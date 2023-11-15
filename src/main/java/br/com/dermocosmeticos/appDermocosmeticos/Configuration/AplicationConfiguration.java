package br.com.dermocosmeticos.appDermocosmeticos.Configuration;

import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.ResultUtil;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.ResultUtilTransactional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AplicationConfiguration {

    @Bean
    public ResultUtil resultUtil() {
        return new ResultUtil();
    }

    @Bean
    public ResultUtilTransactional resultUtilTransactional() {return  new ResultUtilTransactional();}
}
