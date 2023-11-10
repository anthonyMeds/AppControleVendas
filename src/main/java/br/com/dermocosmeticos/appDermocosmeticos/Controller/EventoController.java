package br.com.dermocosmeticos.appDermocosmeticos.Controller;

import br.com.dermocosmeticos.appDermocosmeticos.Dto.EventoDto;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    EventoService eventoService;

    @GetMapping
    public ResponseEntity<EventoDto.Response.BuscaEvento> buscarEvento() {

        return eventoService.buscarEvento();
    }

}
