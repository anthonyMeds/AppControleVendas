package br.com.dermocosmeticos.appDermocosmeticos.Model.Service;

import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Result;
import br.com.dermocosmeticos.appDermocosmeticos.Dto.EventoDto;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface EventoService {

    ResponseEntity<Result<List<EventoDto.Response.BuscaEvento>>> buscarEvento(String nome, LocalDate data);
}
