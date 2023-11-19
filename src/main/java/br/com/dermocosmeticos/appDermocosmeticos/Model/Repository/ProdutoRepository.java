package br.com.dermocosmeticos.appDermocosmeticos.Model.Repository;

import br.com.dermocosmeticos.appDermocosmeticos.Dto.ProdutoDto;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static br.com.dermocosmeticos.appDermocosmeticos.Model.Repository.impl.ProdutoRepositoryImpl.*;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(nativeQuery = true,
            value = BUSCAR_PRODUTOS)
    Page<ProdutoDto.Response.BuscaProduto> buscarProdutos(Pageable pageable);

    boolean existsByProdutoNome(String produtoNome);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = CADASTRAR_PRODUTO)
    int cadastrar(String produtoNome, String produtoCategoria, String produtoMarca, BigDecimal precoUnitario);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = ATUALIZAR_PRODUTO)
    int atualizar(String produtoNome, String produtoCategoria, String produtoMarca, BigDecimal precoUnitario, Long idDoProduto);
}
