package br.com.dermocosmeticos.appDermocosmeticos.Model.Repository.impl;

public class ProdutoRepositoryImpl {

    public static final String BUSCAR_PRODUTOS = "select produto_id as idDoProduto, " +
            "produto_nome as nomeDoProduto, " +
            "produto_categoria as categoriaDoProduto, " +
            "produto_marca as marcaDoProduto, " +
            "preco_unitario as precoUnitario " +
            "from tb_produto";

    public static final String CADASTRAR_PRODUTO = "INSERT INTO tb_produto " +
            "(produto_nome, " +
            "produto_categoria, " +
            "produto_marca, " +
            "preco_unitario) " +
            "VALUES " +
            "(?1, " +
            "?2, " +
            "?3, " +
            "?4)";

    public static final String ATUALIZAR_PRODUTO =
            "UPDATE tb_produto " +
                    "SET " +
                    "  produto_nome = COALESCE(?1, produto_nome), " +
                    "  produto_categoria = COALESCE(?2, produto_categoria), " +
                    "  produto_marca = COALESCE(?3, produto_marca), " +
                    "  preco_unitario = COALESCE(?4, preco_unitario) " +
                    "WHERE produto_id = ?5";

}
