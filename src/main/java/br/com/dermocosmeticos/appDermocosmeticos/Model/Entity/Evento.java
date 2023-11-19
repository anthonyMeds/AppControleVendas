package br.com.dermocosmeticos.appDermocosmeticos.Model.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "tb_evento")
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evento_id")
    private Long idDoEvento;

    @Column(name = "evento_nome")
    private String nomeDoEvento;

    @Column(name = "evento_data")
    private LocalDate dataDoEvento;

    @Column(name = "evento_horario_inicio")
    private LocalTime horarioDoEventoInicio;

    @Column(name = "evento_horario_termino")
    private LocalTime horarioDoEventoTermino;

    @Column(name = "evento_endereco")
    private String enderecoDoEvento;

    @Column(name = "evento_endereco_numero")
    private String numeroDoEndereco;

    @Column(name = "evento_endereco_rua")
    private String ruaDoEndereco;

    @Column(name = "evento_endereco_bairro")
    private String bairroDoEndereco;
}
