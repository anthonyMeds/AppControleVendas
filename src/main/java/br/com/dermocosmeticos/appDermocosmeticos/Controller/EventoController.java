package br.com.dermocosmeticos.appDermocosmeticos.Controller;

import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Result;
import br.com.dermocosmeticos.appDermocosmeticos.Dto.EventoDto;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/eventos" , produces = MediaType.APPLICATION_JSON_VALUE)
public class EventoController {

    @Autowired
    EventoService eventoService;

    @GetMapping("buscar")
    public ResponseEntity<Result<List<EventoDto.Response.BuscaEvento>>> buscarEvento(
            @RequestParam(required = false) String nome,
           @RequestParam(required = false) LocalDate data) {

        return eventoService.buscarEvento(nome, data);
    }

}
