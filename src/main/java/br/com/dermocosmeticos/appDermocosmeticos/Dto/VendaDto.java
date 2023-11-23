package br.com.dermocosmeticos.appDermocosmeticos.Dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

public enum VendaDto {;

    public enum Request {;

        @Data
        public static class Cadastro {
            private String nomeCliente;
            private String telefoneCliente;
            private String nomeVendedor;
            private LocalDate dataVenda;
            private Long eventoVenda;
        }

        public static class Atualizacao extends Cadastro {}
    }

    public enum Response {;

        public interface BuscaVenda {
            Long getIdVenda();
            String getNomeCliente();
            String getTelefoneCliente();
            String getNomeVendedor();
            LocalDate getDataVenda();
            Long getEventoVenda();
        }
    }
}
