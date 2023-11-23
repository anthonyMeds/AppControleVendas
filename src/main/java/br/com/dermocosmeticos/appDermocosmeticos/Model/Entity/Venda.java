package br.com.dermocosmeticos.appDermocosmeticos.Model.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_vendas")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Venda")
    private Long idVenda;

    @Column(name = "Nome_Cliente")
    private String nomeCliente;

    @Column(name = "Telefone_Cliente")
    private String telefoneCliente;

    @Column(name = "Nome_Vendedor")
    private String nomeVendedor;

    @Column(name = "Data_Venda")
    private LocalDate dataVenda;

    @Column(name = "Evento_Venda")
    private Long eventoVenda;


}
