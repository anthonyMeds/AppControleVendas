package br.com.dermocosmeticos.appDermocosmeticos.Model.Service;

import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Paginacao.Paginacao;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.EntidadeResult;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.Result;
import br.com.dermocosmeticos.appDermocosmeticos.Dto.VendaDto;
import org.springframework.http.ResponseEntity;

public interface VendaService {

    ResponseEntity<Result<Paginacao<VendaDto.Response.BuscaVenda>>> buscarVenda(Integer pagina, Integer elementosPorPagina);

    ResponseEntity<EntidadeResult> cadastrarVenda(VendaDto.Request.Cadastro cadastro);

    ResponseEntity<EntidadeResult> atualizarVenda(VendaDto.Request.Atualizacao atualizacao);

    ResponseEntity<EntidadeResult> excluirVenda(Long idVenda);
}
