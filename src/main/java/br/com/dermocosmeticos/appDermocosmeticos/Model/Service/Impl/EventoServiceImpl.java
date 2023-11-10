package br.com.dermocosmeticos.appDermocosmeticos.Model.Service.Impl;

import br.com.dermocosmeticos.appDermocosmeticos.Dto.EventoDto;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Repository.EventoRepository;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    EventoRepository eventoRepository;

    @Override
    public ResponseEntity<EventoDto.Response.BuscaEvento> buscarEvento() {
        return null;
    }
}
