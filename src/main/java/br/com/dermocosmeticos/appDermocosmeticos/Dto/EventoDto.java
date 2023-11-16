package br.com.dermocosmeticos.appDermocosmeticos.Dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;

public enum EventoDto {;

    protected interface IdDoEvento {
        Long getIdDoEvento();
    }
    protected interface NomeDoEvento {
        @NotNull
        @Size(max = 100)
        String getNomeDoEvento();
    }

    protected interface DataDoEvento {
        @NotNull
        LocalDate getDataDoEvento();
    }

    public enum Request {;

        @Data
        public static class Cadastro implements NomeDoEvento, DataDoEvento {
            private String nomeDoEvento;
            private LocalDate dataDoEvento;
        }
    }

    public enum Response {;

        public interface BuscaEvento {
            Long getIdDoEvento();
            String getNomeDoEvento();

            @JsonIgnore
            LocalDate getDataDoEvento();
            @Value("#{@eventoServiceImpl.formatarData(target.dataDoEvento)}")
            @JsonProperty(value = "dataDoEvento")
            String getDataDoEventoFormatada();

        }
    }
}
