package br.com.dermocosmeticos.appDermocosmeticos.Controller;

import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Result;
import br.com.dermocosmeticos.appDermocosmeticos.Dto.EventoDto;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Service.EventoService;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            @RequestParam(required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dataDoEvento) {

        return eventoService.buscarEvento(nomeDoEvento, dataDoEvento);
    }

}
