package br.com.dermocosmeticos.appDermocosmeticos.Model.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
    private Long produtoId;

    @Column(name = "produto_nome")
    private String nomeDoProduto;

    @Column(name = "produto_categoria")
    private String produtoCategoria;

    @Column(name = "produto_marca")
    private String produtoMarca;

    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;
}
