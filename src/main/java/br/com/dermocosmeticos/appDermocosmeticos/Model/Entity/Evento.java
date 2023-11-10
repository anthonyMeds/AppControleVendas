package br.com.dermocosmeticos.appDermocosmeticos.Model.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_evento")
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evento_id")
    private Long id;

    @Column(name = "evento_nome")
    private String nomeDoEvento;

    @Column(name = "evento_data")
    private LocalDate dataEvento;
}
