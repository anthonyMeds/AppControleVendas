package br.com.dermocosmeticos.appDermocosmeticos.Model.Service;

import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Exception.ServiceException;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Paginacao.Paginacao;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.EntidadeResult;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.Result;
import br.com.dermocosmeticos.appDermocosmeticos.Dto.ProdutoDto;
import org.springframework.http.ResponseEntity;

public interface ProdutoService {

    ResponseEntity<Result<Paginacao<ProdutoDto.Response.BuscaProduto>>> buscarProduto(Integer pagina, Integer elementosPorPagina, String nomeCampoColuna, String tipoOrdenacao);

    ResponseEntity<EntidadeResult> cadastrarProduto(ProdutoDto.Request.Cadastro cadastro) throws ServiceException;

    ResponseEntity<EntidadeResult> atualizarProduto(ProdutoDto.Request.Atualizacao atualizacao) throws ServiceException;

    ResponseEntity<EntidadeResult> excluirProduto(Long idDoProduto) throws ServiceException;
}
