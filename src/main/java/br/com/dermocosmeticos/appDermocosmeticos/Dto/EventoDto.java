package br.com.dermocosmeticos.appDermocosmeticos.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.LocalTime;

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

    protected interface HorarioDoEventoInicio {
        LocalTime getHorarioDoEventoInicio();
    }

    protected interface HorarioDoEventoTermino {
        LocalTime getHorarioDoEventoTermino();
    }

    protected interface EnderecoDoEvento {
        String getEnderecoDoEvento();
    }

    protected interface NumeroDoEndereco {
        String getNumeroDoEndereco();
    }

    protected interface RuaDoEndereco {
        String getRuaDoEndereco();
    }

    protected interface BairroDoEndereco {
        String getBairroDoEndereco();
    }

    public enum Request {;

        @Data
        public static class Cadastro implements NomeDoEvento, DataDoEvento, HorarioDoEventoInicio, HorarioDoEventoTermino, EnderecoDoEvento {
            private String nomeDoEvento;
            private LocalDate dataDoEvento;
            private LocalTime horarioDoEventoInicio;
            private LocalTime horarioDoEventoTermino;
            private String enderecoDoEvento;
            private String numeroDoEndereco;
            private String ruaDoEndereco;
            private String bairroDoEndereco;
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

            LocalTime getHorarioDoEventoInicio();
            LocalTime getHorarioDoEventoTermino();

            String getEnderecoDoEvento();
            String getNumeroDoEndereco();
            String getRuaDoEndereco();

            String getBairroDoEndereco();
        }
    }
}
