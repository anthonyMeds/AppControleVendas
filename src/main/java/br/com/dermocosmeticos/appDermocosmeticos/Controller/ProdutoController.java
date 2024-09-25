package br.com.dermocosmeticos.appDermocosmeticos.Controller;

import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Annotations.ValoresPermitidos;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Exception.ServiceException;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Paginacao.Paginacao;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.EntidadeResult;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.Result;
import br.com.dermocosmeticos.appDermocosmeticos.Dto.ProdutoDto;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;

@Validated
@RestController
@RequestMapping(value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("buscar")
    public ResponseEntity<Result<Paginacao<ProdutoDto.Response.BuscaProduto>>> buscarProduto(
            @RequestParam(defaultValue = "0") @PositiveOrZero Integer pagina,
            @RequestParam(defaultValue = "15") @PositiveOrZero @Min(1) Integer elementosPorPagina,
            @ValoresPermitidos(value = {"nomeDoProduto", "produtoCategoria", "produtoMarca", "precoUnitario"})
            @RequestParam(defaultValue = "nomeDoProduto") String nomeCampoColuna,
            @RequestParam(defaultValue = "asc") @ValoresPermitidos({"asc", "desc"}) String tipoOrdenacao
    ) {
        return produtoService.buscarProduto(pagina, elementosPorPagina, nomeCampoColuna, tipoOrdenacao);
    }

    @PostMapping("cadastrar")
    public ResponseEntity<EntidadeResult> cadastrarProduto(
            @RequestBody @Valid ProdutoDto.Request.Cadastro cadastro) throws ServiceException {
        return produtoService.cadastrarProduto(cadastro);
    }

    @PutMapping(value = "atualizar")
    public ResponseEntity<EntidadeResult> atualizarProduto(
            @RequestBody @Valid ProdutoDto.Request.Atualizacao atualizacao) throws ServiceException {
        return produtoService.atualizarProduto(atualizacao);
    }

    @DeleteMapping("excluir")
    public ResponseEntity<EntidadeResult> excluirProduto(
            @RequestParam @PositiveOrZero Long idDoProduto) throws ServiceException {
        return produtoService.excluirProduto(idDoProduto);
    }
}
