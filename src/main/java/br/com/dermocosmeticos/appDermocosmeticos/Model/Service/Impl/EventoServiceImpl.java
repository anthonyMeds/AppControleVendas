package br.com.dermocosmeticos.appDermocosmeticos.Model.Service.Impl;

import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Result;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.ResultUtil;
import br.com.dermocosmeticos.appDermocosmeticos.Dto.EventoDto;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Repository.EventoRepository;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private ResultUtil<List<EventoDto.Response.BuscaEvento>> resultUtilBuscarEvento;


    @Autowired
    EventoRepository eventoRepository;

    @Override
    public ResponseEntity<Result<List<EventoDto.Response.BuscaEvento>>> buscarEvento(String nome, LocalDate data) {

        List<EventoDto.Response.BuscaEvento> listaEventos = null;

        if (nome == null || nome.isEmpty() || data == null) {
            listaEventos = eventoRepository.buscarUltimosCincoEventos();
        } else {
            listaEventos = eventoRepository.buscarEventos(nome, data);
        }

        if (listaEventos == null || listaEventos.isEmpty()) {
            return resultUtilBuscarEvento.resultSucesso(HttpStatus.OK, "Não foram encontrados eventos cadastrados com esses parâmetros.", Collections.emptyList());
        }
        return resultUtilBuscarEvento.resultSucesso(HttpStatus.OK, listaEventos);
    }
}
