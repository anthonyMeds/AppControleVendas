package br.com.dermocosmeticos.appDermocosmeticos.Model.Repository;

import br.com.dermocosmeticos.appDermocosmeticos.Dto.EventoDto;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Entity.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    Page<EventoDto.Response.BuscaEvento> buscarEventos (Pageable pageable);


    @Query(nativeQuery = true,
            value = BUSCAR_ULTIMOS_5_EVENTOS)
    List<EventoDto.Response.BuscaEvento> buscarUltimosCincoEventos();

    boolean existsByNomeDoEventoAndDataDoEvento(String nomeDoEvento, LocalDate dataDoEvento);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = CADASTRAR_EVENTO)
    int cadastrar(String nomeDoEvento, String dataDoEvento, String horarioDoEventoInicio, String horarioDoEventoTermino,
                  String enderecoDoEvento, String numeroDoEndereco, String ruaDoEndereco, String bairroDoEndereco);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = ATUALIZAR_EVENTO)
    int atualizar(String nomeDoEvento, String dataDoEvento, String horarioDoEventoInicio, String horarioDoEventoTermino,
                  String enderecoDoEvento, String numeroDoEndereco, String ruaDoEndereco, String bairroDoEndereco, Long idDoEvento);

}
