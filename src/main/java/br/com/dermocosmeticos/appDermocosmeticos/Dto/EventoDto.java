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
        @Size(max = 100)
        String getNomeDoEvento();
    }

    protected interface DataDoEvento {
        LocalDate getDataDoEvento();
    }

    protected interface HorarioDoEventoInicio {
        LocalTime getHorarioDoEventoInicio();
    }

    protected interface HorarioDoEventoTermino {
        LocalTime getHorarioDoEventoTermino();
    }

    protected interface EnderecoDoEvento {
        @Size(max = 255)
        String getEnderecoDoEvento();
    }

    protected interface NumeroDoEndereco {
        @Size(max = 255)
        String getNumeroDoEndereco();
    }

    protected interface RuaDoEndereco {
        @Size(max = 255)
        String getRuaDoEndereco();
    }

    protected interface BairroDoEndereco {
        @Size(max = 255)
        String getBairroDoEndereco();
    }

    public enum Request {;

        @Data
        public static class Cadastro implements IdDoEvento, NomeDoEvento, DataDoEvento, HorarioDoEventoInicio, HorarioDoEventoTermino,
                EnderecoDoEvento, NumeroDoEndereco, RuaDoEndereco, BairroDoEndereco {
            private Long idDoEvento;
            private String nomeDoEvento;
            private LocalDate dataDoEvento;
            private LocalTime horarioDoEventoInicio;
            private LocalTime horarioDoEventoTermino;
            private String enderecoDoEvento;
            private String numeroDoEndereco;
            private String ruaDoEndereco;
            private String bairroDoEndereco;
        }

        public static class Atualizacao extends Cadastro {}
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
