package br.com.dermocosmeticos.appDermocosmeticos.Configuration.Data;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

import static br.com.dermocosmeticos.appDermocosmeticos.Configuration.Data.DataUtil.*;

@Configuration
public class DataConfiguration {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> {
            // Serializers
            builder.serializers(new LocalTimeSerializer(DateTimeFormatter.ofPattern(HHMM_DOIS_PONTOS).withResolverStyle(ResolverStyle.STRICT)));
            builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(DDMMAAAA_BARRA).withResolverStyle(ResolverStyle.STRICT)));
            builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(DDMMAAAA_HHMMSS_BARRA).withResolverStyle(ResolverStyle.STRICT)));

            // Deserializers
            builder.deserializers(new LocalTimeDeserializer(DateTimeFormatter.ofPattern(HHMM_DOIS_PONTOS).withResolverStyle(ResolverStyle.STRICT)));
            builder.deserializers(new LocalDateDeserializer(DateTimeFormatter.ofPattern(DDMMAAAA_BARRA).withResolverStyle(ResolverStyle.STRICT)));
            builder.deserializers(new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(DDMMAAAA_HHMMSS_BARRA).withResolverStyle(ResolverStyle.STRICT)));
        };
    }

    @Component
    public class LocalTimeConverter implements Converter<String, LocalTime> {
        @Override
        public LocalTime convert(String hora) {
            return LocalTime.parse(hora, DateTimeFormatter.ofPattern(HHMMSS_DOIS_PONTOS).withResolverStyle(ResolverStyle.STRICT));
        }
    }

    @Component
    public class LocalDateConverter implements Converter<String, LocalDate> {
        @Override
        public LocalDate convert(String data) {
            return LocalDate.parse(data, DateTimeFormatter.ofPattern(DDMMAAAA_BARRA).withResolverStyle(ResolverStyle.STRICT));
        }
    }

    @Component
    public class LocalDateTimeConverter implements Converter<String, LocalDateTime> {
        @Override
        public LocalDateTime convert(String dataHora) {
            return LocalDateTime.parse(dataHora, DateTimeFormatter.ofPattern(DDMMAAAA_HHMMSS_BARRA).withResolverStyle(ResolverStyle.STRICT));
        }
    }
}
