package br.com.dermocosmeticos.appDermocosmeticos.Model.Service;

import br.com.dermocosmeticos.appDermocosmeticos.Dto.EventoDto;
import org.springframework.http.ResponseEntity;

public interface EventoService {

    ResponseEntity<EventoDto.Response.BuscaEvento> buscarEvento();
}
