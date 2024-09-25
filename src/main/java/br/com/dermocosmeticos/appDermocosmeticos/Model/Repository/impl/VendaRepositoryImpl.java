package br.com.dermocosmeticos.appDermocosmeticos.Model.Repository.impl;

public class VendaRepositoryImpl {

    public static final String BUSCAR_VENDAS = "select id_venda as idVenda, " +
            "nome_cliente as nomeCliente, " +
            "telefone_cliente as telefoneCliente, " +
            "nome_vendedor as nomeVendedor, " +
            "data_venda as dataVenda, " +
            "evento_venda as eventoVenda " +
            "from tb_vendas";

    public static final String CADASTRAR_VENDA = "INSERT INTO tb_vendas " +
            "(nome_cliente, " +
            "telefone_cliente, " +
            "nome_vendedor, " +
            "data_venda, " +
            "evento_venda) " +
            "VALUES " +
            "(?1, " +
            "?2, " +
            "?3, " +
            "?4, " +
            "?5)";

    public static final String ATUALIZAR_VENDA =
            "UPDATE tb_vendas " +
                    "SET " +
                    "  nome_cliente = COALESCE(?1, nome_cliente), " +
                    "  telefone_cliente = COALESCE(?2, telefone_cliente), " +
                    "  nome_vendedor = COALESCE(?3, nome_vendedor), " +
                    "  data_venda = COALESCE(?4, data_venda), " +
                    "  evento_venda = COALESCE(?5, evento_venda) " +
                    "WHERE id_venda = ?6";
}
