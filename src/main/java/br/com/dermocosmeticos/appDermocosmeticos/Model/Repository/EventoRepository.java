package br.com.dermocosmeticos.appDermocosmeticos.Model.Repository;

import br.com.dermocosmeticos.appDermocosmeticos.Dto.EventoDto;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static br.com.dermocosmeticos.appDermocosmeticos.Model.Repository.impl.EventoRepositoryImpl.*;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    @Query(nativeQuery = true,
    value = BUSCAR_EVENTOS)
    List<EventoDto.Response.BuscaEvento> buscarEventos (String nome, LocalDate data);


    @Query(nativeQuery = true,
            value = BUSCAR_ULTIMOS_5_EVENTOS)
    List<EventoDto.Response.BuscaEvento> buscarUltimosCincoEventos();

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = CADASTRAR_EVENTO)
    int cadastrar(String nomeDoEvento, LocalDate dataDoEvento);
}
