package br.com.dermocosmeticos.appDermocosmeticos.Configuration;

import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Paginacao.OrdenacaoPaginacaoUtil;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.ResultUtil;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.ResultUtilTransactional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.util.Locale;

@Configuration
public class AplicationConfiguration {

    @Bean
    public LocaleResolver localeResolver() {
        return new FixedLocaleResolver(new Locale("pt", "BR"));
    }

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    @Bean
    public ResultUtil resultUtil() {
        return new ResultUtil();
    }

    @Bean
    public ResultUtilTransactional resultUtilTransactional() {return  new ResultUtilTransactional();}

    @Bean
    public OrdenacaoPaginacaoUtil ordenacaoPaginacaoUtil() {return  new OrdenacaoPaginacaoUtil();}


}
