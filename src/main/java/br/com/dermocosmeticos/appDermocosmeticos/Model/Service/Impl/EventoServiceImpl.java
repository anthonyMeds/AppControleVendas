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
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private ResultUtil<List<EventoDto.Response.BuscaEvento>> resultUtilBuscarEvento;


    @Autowired
    EventoRepository eventoRepository;

    @Override
    public ResponseEntity<Result<List<EventoDto.Response.BuscaEvento>>> buscarEvento(String nomeDoEvento, LocalDate dataDoEvento) {

        List<EventoDto.Response.BuscaEvento> listaEventos = null;

        if ((nomeDoEvento == null || nomeDoEvento.equals("")) && dataDoEvento == null) {
            listaEventos = eventoRepository.buscarUltimosCincoEventos();
        } else {
            listaEventos = eventoRepository.buscarEventos(nomeDoEvento, dataDoEvento);
        }

        if (listaEventos == null || listaEventos.isEmpty()) {
            return resultUtilBuscarEvento.resultSucesso(HttpStatus.OK, "Não foram encontrados eventos cadastrados com esses parâmetros.", Collections.emptyList());
        }
        return resultUtilBuscarEvento.resultSucesso(HttpStatus.OK, listaEventos);
    }

    public String formatarData(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }
}
