package br.com.dermocosmeticos.appDermocosmeticos.Model.Repository.impl;

public class EventoRepositoryImpl {

    public static final String BUSCAR_EVENTOS = "select evento_id as idDoEvento, " +
            "evento_nome as nomeDoEvento, " +
            "evento_data as dataDoEvento, " +
            "evento_horario_inicio as horarioDoEventoInicio, " +
            "evento_horario_termino as horarioDoEventoTermino, " +
            "evento_endereco as enderecoDoEvento, " +
            "evento_endereco_numero as numeroDoEndereco, " +
            "evento_endereco_rua as ruaDoEndereco, " +
            "evento_endereco_bairro as bairroDoEndereco " +
            "from tb_evento";

    public static final String BUSCAR_ULTIMOS_5_EVENTOS = "SELECT evento_id as idDoEvento, " +
            "evento_nome as nomeDoEvento, " +
            "evento_data as dataDoEvento, " +
            "evento_horario_inicio as horarioDoEventoInicio, " +
            "evento_horario_termino as horarioDoEventoTermino, " +
            "evento_endereco as enderecoDoEvento, " +
            "evento_endereco_numero as numeroDoEndereco, " +
            "evento_endereco_rua as ruaDoEndereco, " +
            "evento_endereco_bairro as bairroDoEndereco " +
            "FROM tb_evento " +
            "ORDER BY evento_data DESC " +
            "LIMIT 5";

    public static final String CADASTRAR_EVENTO = "INSERT INTO tb_evento " +
            "(evento_nome, " +
            "evento_data, " +
            "evento_horario_inicio as horarioDoEventoInicio, " +
            "evento_horario_termino as horarioDoEventoTermino, " +
            "evento_endereco, " +
            "evento_endereco_numero, " +
            "evento_endereco_rua, " +
            "evento_endereco_bairro) " +
            "VALUES " +
            "(?1, " +
            "STR_TO_DATE(?2, '%d/%m/%Y'), " +
            "STR_TO_DATE(?3, '%H:%i'), " +
            "STR_TO_DATE(?4, '%H:%i'), " +
            "?4, " +
            "?5, " +
            "?6, " +
            "?7)";





}
