package br.com.dermocosmeticos.appDermocosmeticos.Controller;

import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Paginacao.Paginacao;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.EntidadeResult;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.Result;
import br.com.dermocosmeticos.appDermocosmeticos.Dto.VendaDto;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Service.VendaService;
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
@RequestMapping(value = "/vendas", produces = MediaType.APPLICATION_JSON_VALUE)
public class VendaController {

    @Autowired
    VendaService vendaService;

    @GetMapping("buscar")
    public ResponseEntity<Result<Paginacao<VendaDto.Response.BuscaVenda>>> buscarVenda(
            @RequestParam(defaultValue = "0") @PositiveOrZero Integer pagina,
            @RequestParam(defaultValue = "15") @PositiveOrZero @Min(1) Integer elementosPorPagina
    ) {
        return vendaService.buscarVenda(pagina, elementosPorPagina);
    }

    @PostMapping("cadastrar")
    public ResponseEntity<EntidadeResult> cadastrarVenda(
            @RequestBody @Valid VendaDto.Request.Cadastro cadastro) {
        return vendaService.cadastrarVenda(cadastro);
    }

    @PutMapping(value = "atualizar")
    public ResponseEntity<EntidadeResult> atualizarVenda(
            @RequestBody @Valid VendaDto.Request.Atualizacao atualizacao) {
        return vendaService.atualizarVenda(atualizacao);
    }

    @DeleteMapping("excluir")
    public ResponseEntity<EntidadeResult> excluirVenda(
            @RequestParam @PositiveOrZero Long idVenda) {
        return vendaService.excluirVenda(idVenda);
    }
}
