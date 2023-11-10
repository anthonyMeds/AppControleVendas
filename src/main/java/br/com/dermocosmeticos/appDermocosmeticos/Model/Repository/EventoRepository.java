package br.com.dermocosmeticos.appDermocosmeticos.Model.Repository;

import br.com.dermocosmeticos.appDermocosmeticos.Model.Entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
}
