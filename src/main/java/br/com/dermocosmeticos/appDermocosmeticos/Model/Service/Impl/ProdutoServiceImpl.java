package br.com.dermocosmeticos.appDermocosmeticos.Model.Service.Impl;

import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Exception.ServiceException;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Paginacao.OrdenacaoPaginacaoUtil;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Paginacao.Paginacao;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.EntidadeResult;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.Result;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.ResultUtil;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.ResultUtilTransactional;
import br.com.dermocosmeticos.appDermocosmeticos.Dto.ProdutoDto;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Repository.ProdutoRepository;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ResultUtil<Paginacao<ProdutoDto.Response.BuscaProduto>> resultUtilBuscarProduto;

    @Autowired
    private ResultUtilTransactional resultUtilTransactional;

    @Autowired
    private OrdenacaoPaginacaoUtil ordenacaoPaginacaoUtil;

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public ResponseEntity<Result<Paginacao<ProdutoDto.Response.BuscaProduto>>>
    buscarProduto(Integer pagina, Integer elementosPorPagina, String nomeCampoColuna, String tipoOrdenacao) {

        Page<ProdutoDto.Response.BuscaProduto> listaProdutos = null;

        listaProdutos = produtoRepository.buscarProdutos(PageRequest.of(pagina, elementosPorPagina,
                Sort.by(ordenacaoPaginacaoUtil.ordenarPaginacao(nomeCampoColuna, tipoOrdenacao))));

        if (listaProdutos.getTotalElements() == 0) {
            return resultUtilBuscarProduto.resultSucesso(HttpStatus.OK, "Não foram encontrados produtos cadastrados com esses parâmetros.", new Paginacao<>(Page.empty()));
        }
        return resultUtilBuscarProduto.resultSucesso(HttpStatus.OK, new Paginacao<>(listaProdutos));
    }

    @Override
    public ResponseEntity<EntidadeResult> cadastrarProduto(ProdutoDto.Request.Cadastro cadastro) throws ServiceException {

        if (cadastro.getNomeDoProduto() == null) {
            throw new ServiceException("Para cadastrar um novo produto, nome é obrigatório.");
        }

        if (produtoRepository.existsByNomeDoProduto(cadastro.getNomeDoProduto())) {
            throw new ServiceException("Já existe um produto cadastrado com esse nome.");
        }

        produtoRepository.cadastrar(cadastro.getNomeDoProduto(), cadastro.getCategoriaDoProduto(),
                cadastro.getMarcaDoProduto(), cadastro.getPrecoUnitario());

        return resultUtilTransactional.resultSucesso(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<EntidadeResult> atualizarProduto(ProdutoDto.Request.Atualizacao atualizacao) throws ServiceException {

        if (atualizacao.getIdDoProduto() == null) {
            throw new ServiceException("Informe o id do produto desejado para atualizar");
        }

        produtoRepository.findById(atualizacao.getIdDoProduto()).orElseThrow(() ->
                new ServiceException("Produto não encontrado."));

        produtoRepository.atualizar(atualizacao.getNomeDoProduto(), atualizacao.getCategoriaDoProduto(), atualizacao.getMarcaDoProduto(),
                atualizacao.getPrecoUnitario(), atualizacao.getIdDoProduto());

        return resultUtilTransactional.resultSucesso(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EntidadeResult> excluirProduto(Long idDoProduto) throws ServiceException {

        produtoRepository.findById(idDoProduto).orElseThrow(() ->
                new ServiceException("Produto não encontrado."));

        produtoRepository.deleteById(idDoProduto);

        return resultUtilTransactional.resultSucesso(HttpStatus.OK);
    }
}
