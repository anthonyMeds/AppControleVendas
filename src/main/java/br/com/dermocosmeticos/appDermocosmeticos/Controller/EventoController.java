package br.com.dermocosmeticos.appDermocosmeticos.Controller;

import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Annotations.ValoresPermitidos;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Exception.ServiceException;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Paginacao.Paginacao;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.EntidadeResult;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.Result;
import br.com.dermocosmeticos.appDermocosmeticos.Dto.EventoDto;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Service.EventoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/eventos" , produces = MediaType.APPLICATION_JSON_VALUE)
public class EventoController {

    @Autowired
    EventoService eventoService;

    @GetMapping("buscar")
    public ResponseEntity<Result<Paginacao<EventoDto.Response.BuscaEvento>>> buscarEvento(
            @RequestParam(defaultValue = "0") @PositiveOrZero Integer pagina,
            @RequestParam(defaultValue = "15") @PositiveOrZero @Min(1) Integer elementosPorPagina,
            @ValoresPermitidos(value = {"nomeDoEvento","dataDoEvento", "horarioDoEventoInicio", "horarioDoEventoTermino", "enderecoDoEvento",
            "bairroDoEndereco", "numeroDoEndereco", "ruaDoEndereco"})
            @RequestParam(defaultValue = "dataDoEvento") String nomeCampoColuna,
            @RequestParam(defaultValue = "desc") @ValoresPermitidos({"asc", "desc"}) String tipoOrdenacao
    ) {

        return eventoService.buscarEvento(pagina, elementosPorPagina, nomeCampoColuna, tipoOrdenacao);
    }

    @PostMapping("cadastrar")
    public ResponseEntity<EntidadeResult> cadastrarEvento(
            @RequestBody @Valid EventoDto.Request.Cadastro cadastro) throws ServiceException {
        return eventoService.cadastrarEvento(cadastro);
    }

}
