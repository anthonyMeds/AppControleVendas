package br.com.dermocosmeticos.appDermocosmeticos.Dto;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

public enum ProdutoDto {;

    protected interface IdDoProduto {
        Long getIdDoProduto();
    }

    protected interface NomeDoProduto {
        @Size(max = 255)
        String getNomeDoProduto();
    }

    protected interface CategoriaDoProduto {
        @Size(max = 255)
        String getCategoriaDoProduto();
    }

    protected interface MarcaDoProduto {
        @Size(max = 255)
        String getMarcaDoProduto();
    }

    protected interface PrecoUnitario {
        BigDecimal getPrecoUnitario();
    }

    public enum Request {;

        @Data
        public static class Cadastro implements IdDoProduto, NomeDoProduto, CategoriaDoProduto, MarcaDoProduto, PrecoUnitario {
            private Long idDoProduto;
            private String nomeDoProduto;
            private String categoriaDoProduto;
            private String marcaDoProduto;
            private BigDecimal precoUnitario;
        }

        public static class Atualizacao extends Cadastro {}
    }

    public enum Response {;

        public interface BuscaProduto {
            Long getIdDoProduto();
            String getNomeDoProduto();
            String getCategoriaDoProduto();
            String getMarcaDoProduto();
            BigDecimal getPrecoUnitario();
        }
    }
}
