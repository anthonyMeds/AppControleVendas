package br.com.dermocosmeticos.appDermocosmeticos.Configuration.Data;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class DataUtil {
    public static final String HHMM_BASICO = "HHmm";
    public static final String HHMMSS_BASICO = "HHmmss";
    public static final String HHMM_DOIS_PONTOS = "HH:mm";
    public static final String HHMMSS_DOIS_PONTOS = "HH:mm:ss";
    public static final String AAAAMMDD_BASICO = "uuuuMMdd";
    public static final String AAAAMMDD_HIFEN = "uuuu-MM-dd";
    public static final String DDMMAAAA_BARRA = "dd/MM/uuuu";
    public static final String DDMMAAAA_BASICO = "ddMMuuuu";
    public static final String AAAAMMDD_HHMMSS_BASICO = "uuuuMMdd HHmmss";
    public static final String AAAAMMDD_HHMMSS_HIFEN = "uuuu-MM-dd HH:mm:ss";
    public static final String DDMMAAAA_HHMMSS_BARRA = "dd/MM/uuuu HH:mm:ss";
    public static final String DDMMAAAA_HHMMSS_BASICO = "ddMMuuuu HHmmss";

    public DataUtil() {
    }

    public static boolean isDateWithinRange(LocalDate data, LocalDate dataIncio, LocalDate dataFim) {
        return !data.isBefore(dataIncio) && !data.isAfter(dataFim);
    }

    public static LocalTime parseLocalTime(String hora) {
        return hora != null ? parseLocalTime(hora, "HH:mm:ss") : null;
    }

    public static LocalTime parseLocalTime(String hora, String formatoDesejado) {
        return hora != null ? LocalTime.parse(hora, DateTimeFormatter.ofPattern(formatoDesejado).withResolverStyle(ResolverStyle.STRICT)) : null;
    }

    public static LocalDate parseLocalDate(String data) {
        return data != null ? parseLocalDate(data, "dd/MM/uuuu") : null;
    }

    public static LocalDate parseLocalDate(String data, String formatoDesejado) {
        return data != null ? LocalDate.parse(data, DateTimeFormatter.ofPattern(formatoDesejado).withResolverStyle(ResolverStyle.STRICT)) : null;
    }

    public static LocalDateTime parseLocalDateTime(String dataHora) {
        return dataHora != null ? parseLocalDateTime(dataHora, "dd/MM/uuuu HH:mm:ss") : null;
    }

    public static LocalDateTime parseLocalDateTime(String dataHora, String formatoDesejado) {
        return dataHora != null ? LocalDateTime.parse(dataHora, DateTimeFormatter.ofPattern(formatoDesejado).withResolverStyle(ResolverStyle.STRICT)) : null;
    }

    public static String formatar(LocalTime localTime) {
        return localTime != null ? formatar(localTime, "HH:mm:ss") : null;
    }

    public static String formatar(LocalTime localTime, String formatoDesejado) {
        return localTime != null ? localTime.format(DateTimeFormatter.ofPattern(formatoDesejado).withResolverStyle(ResolverStyle.STRICT)) : null;
    }

    public static String formatar(LocalDate localDate) {
        return localDate != null ? formatar(localDate, "dd/MM/uuuu") : null;
    }

    public static String formatar(LocalDate localDate, String formatoDesejado) {
        return localDate != null ? localDate.format(DateTimeFormatter.ofPattern(formatoDesejado).withResolverStyle(ResolverStyle.STRICT)) : null;
    }

    public static String formatar(LocalDateTime localDateTime) {
        return localDateTime != null ? formatar(localDateTime, "dd/MM/uuuu HH:mm:ss") : null;
    }

    public static String formatar(LocalDateTime localDateTime, String formatoDesejado) {
        return localDateTime != null ? localDateTime.format(DateTimeFormatter.ofPattern(formatoDesejado).withResolverStyle(ResolverStyle.STRICT)) : null;
    }
}

