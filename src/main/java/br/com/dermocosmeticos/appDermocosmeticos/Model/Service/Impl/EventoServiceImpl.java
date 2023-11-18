package br.com.dermocosmeticos.appDermocosmeticos.Model.Service.Impl;

import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Data.DataUtil;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Exception.ServiceException;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.EntidadeResult;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.Result;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.ResultUtil;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.ResultUtilTransactional;
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
    private ResultUtilTransactional resultUtilTransactional;


    @Autowired
    EventoRepository eventoRepository;

    @Override
    public ResponseEntity<Result<List<EventoDto.Response.BuscaEvento>>> buscarEvento(String nomeDoEvento, LocalDate dataDoEvento) {

        List<EventoDto.Response.BuscaEvento> listaEventos = null;

        if ((nomeDoEvento == null || nomeDoEvento.equals("")) && dataDoEvento == null) {
            listaEventos = eventoRepository.buscarUltimosCincoEventos();
        } else {
            listaEventos = eventoRepository.buscarEventos(nomeDoEvento, DataUtil.formatar(dataDoEvento));
        }

        if (listaEventos == null || listaEventos.isEmpty()) {
            return resultUtilBuscarEvento.resultSucesso(HttpStatus.OK, "Não foram encontrados eventos cadastrados com esses parâmetros.", Collections.emptyList());
        }
        return resultUtilBuscarEvento.resultSucesso(HttpStatus.OK, listaEventos);
    }

    @Override
    public ResponseEntity<EntidadeResult> cadastrarEvento(EventoDto.Request.Cadastro cadastro) throws ServiceException {

        if (eventoRepository.existsByNomeDoEventoAndDataDoEvento(cadastro.getNomeDoEvento(), cadastro.getDataDoEvento())){
            throw new ServiceException("Já existe evento cadastrado para essa data com o mesmo nome.");
        }

        eventoRepository.cadastrar(cadastro.getNomeDoEvento(), DataUtil.formatar(cadastro.getDataDoEvento()));

        return resultUtilTransactional.resultSucesso(HttpStatus.CREATED);
    }

    public String formatarData(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }
}
