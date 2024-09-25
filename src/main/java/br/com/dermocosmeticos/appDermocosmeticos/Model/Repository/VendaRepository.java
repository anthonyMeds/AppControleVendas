package br.com.dermocosmeticos.appDermocosmeticos.Model.Repository;

import br.com.dermocosmeticos.appDermocosmeticos.Dto.VendaDto;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Entity.Venda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static br.com.dermocosmeticos.appDermocosmeticos.Model.Repository.impl.VendaRepositoryImpl.*;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    @Query(nativeQuery = true, value = BUSCAR_VENDAS)
    Page<VendaDto.Response.BuscaVenda> buscarVendas(Pageable pageable);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = CADASTRAR_VENDA)
    int cadastrar(String nomeCliente, String telefoneCliente, String nomeVendedor, Long eventoVenda);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = ATUALIZAR_VENDA)
    int atualizar(String nomeCliente, String telefoneCliente, String nomeVendedor, Long eventoVenda, Long idVenda);
}
