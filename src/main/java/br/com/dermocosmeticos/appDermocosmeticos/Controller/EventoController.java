package br.com.dermocosmeticos.appDermocosmeticos.Controller;

import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Exception.ServiceException;
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

import java.time.LocalDate;
import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/eventos" , produces = MediaType.APPLICATION_JSON_VALUE)
public class EventoController {

    @Autowired
    EventoService eventoService;

    @GetMapping("buscar")
    public ResponseEntity<Result<List<EventoDto.Response.BuscaEvento>>> buscarEvento(
            @RequestParam(required = false) @Size(max = 100) String nomeDoEvento,
            @RequestParam(required = false) LocalDate dataDoEvento) {

        return eventoService.buscarEvento(nomeDoEvento, dataDoEvento);
    }

    @PostMapping("cadastrar")
    public ResponseEntity<EntidadeResult> cadastrarEvento(
            @RequestBody @Valid EventoDto.Request.Cadastro cadastro) throws ServiceException {
        return eventoService.cadastrarEvento(cadastro);
    }

}
