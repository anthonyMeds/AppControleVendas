package br.com.dermocosmeticos.appDermocosmeticos.Model.Service.Impl;

import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Data.DataUtil;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Exception.ServiceException;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Paginacao.OrdenacaoPaginacaoUtil;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Paginacao.Paginacao;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.EntidadeResult;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.Result;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.ResultUtil;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.ResultUtilTransactional;
import br.com.dermocosmeticos.appDermocosmeticos.Dto.EventoDto;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Entity.Evento;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Repository.EventoRepository;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private ResultUtil<Paginacao<EventoDto.Response.BuscaEvento>> resultUtilBuscarEvento;

    @Autowired
    private ResultUtilTransactional resultUtilTransactional;

    @Autowired
    private OrdenacaoPaginacaoUtil ordenacaoPaginacaoUtil;


    @Autowired
    EventoRepository eventoRepository;

    @Override
    public ResponseEntity<Result<Paginacao<EventoDto.Response.BuscaEvento>>>
    buscarEvento(Integer pagina, Integer elementosPorPagina, String nomeCampoColuna, String tipoOrdenacao){

        Page<EventoDto.Response.BuscaEvento> listaEventos = null;

        listaEventos = eventoRepository.buscarEventos(PageRequest.of(pagina, elementosPorPagina,
                Sort.by(ordenacaoPaginacaoUtil.ordenarPaginacao(nomeCampoColuna, tipoOrdenacao))));

        if (listaEventos.getTotalElements() == 0) {
            return resultUtilBuscarEvento.resultSucesso(HttpStatus.OK, "Não foram encontrados eventos cadastrados com esses parâmetros.", new Paginacao<>(Page.empty()));
        }
        return resultUtilBuscarEvento.resultSucesso(HttpStatus.OK, new Paginacao<>(listaEventos));
    }

    @Override
    public ResponseEntity<EntidadeResult> cadastrarEvento(EventoDto.Request.Cadastro cadastro) throws ServiceException {

        if (cadastro.getDataDoEvento() == null || cadastro.getNomeDoEvento() == null) {
            throw new ServiceException("Para cadastrar um novo evento, nome e data são obrigatórios.");
        }

        if (eventoRepository.existsByNomeDoEventoAndDataDoEvento(cadastro.getNomeDoEvento(), cadastro.getDataDoEvento())){
            throw new ServiceException("Já existe evento cadastrado para essa data com o mesmo nome.");
        }

        eventoRepository.cadastrar(cadastro.getNomeDoEvento(), DataUtil.formatar(cadastro.getDataDoEvento()),
                DataUtil.formatar(cadastro.getHorarioDoEventoInicio()), DataUtil.formatar(cadastro.getHorarioDoEventoTermino()),
                cadastro.getEnderecoDoEvento(), cadastro.getNumeroDoEndereco(), cadastro.getRuaDoEndereco(), cadastro.getBairroDoEndereco());

        return resultUtilTransactional.resultSucesso(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<EntidadeResult> atualizarEvento(EventoDto.Request.Atualizacao atualizacao) throws ServiceException {

        if (atualizacao.getIdDoEvento() == null) {
            throw new ServiceException("Informe o id do evento desejado para atualizar");
        }

        eventoRepository.findById(atualizacao.getIdDoEvento()).orElseThrow(() ->
            new ServiceException("Evento não encontrado."));

        eventoRepository.atualizar(atualizacao.getNomeDoEvento(), DataUtil.formatar(atualizacao.getDataDoEvento()),
                DataUtil.formatar(atualizacao.getHorarioDoEventoInicio()), DataUtil.formatar(atualizacao.getHorarioDoEventoTermino()),
                atualizacao.getEnderecoDoEvento(), atualizacao.getNumeroDoEndereco(), atualizacao.getRuaDoEndereco(),
                atualizacao.getBairroDoEndereco(), atualizacao.getIdDoEvento());

        return resultUtilTransactional.resultSucesso(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EntidadeResult> excluirEvento(Long idDoEvento) throws ServiceException {

        eventoRepository.findById(idDoEvento).orElseThrow(() ->
                new ServiceException("Evento não encontrado."));

        eventoRepository.deleteById(idDoEvento);

        return resultUtilTransactional.resultSucesso(HttpStatus.OK);
    }

    public String formatarData(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }
}
