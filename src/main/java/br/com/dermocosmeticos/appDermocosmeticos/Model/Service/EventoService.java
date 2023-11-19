package br.com.dermocosmeticos.appDermocosmeticos.Model.Service;

import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Exception.ServiceException;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Paginacao.Paginacao;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.EntidadeResult;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.Result;
import br.com.dermocosmeticos.appDermocosmeticos.Dto.EventoDto;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface EventoService {

    ResponseEntity<Result<Paginacao<EventoDto.Response.BuscaEvento>>> buscarEvento(Integer pagina, Integer elementosPorPagina, String nomeCampoColuna, String tipoOrdenacao);

    ResponseEntity<EntidadeResult> cadastrarEvento(EventoDto.Request.Cadastro cadastro) throws ServiceException;

    ResponseEntity<EntidadeResult> atualizarEvento(EventoDto.Request.Atualizacao atualizacao) throws ServiceException;

    ResponseEntity<EntidadeResult> excluirEvento(Long idDoEvento) throws ServiceException;
}
