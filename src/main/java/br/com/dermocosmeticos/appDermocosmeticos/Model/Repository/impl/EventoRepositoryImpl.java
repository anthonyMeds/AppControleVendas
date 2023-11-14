package br.com.dermocosmeticos.appDermocosmeticos.Model.Repository.impl;

public class EventoRepositoryImpl {

    public static final String BUSCAR_EVENTOS = "select evento_id as idDoEvento, " +
            "evento_nome as nomeDoEvento, " +
            "evento_data as dataDoEvento " +
            "from tb_evento " +
            "WHERE (?1 IS NULL OR evento_nome = ?1 OR evento_nome LIKE CONCAT('%', ?1, '%')) " +
            "AND (?2 IS NULL OR evento_data = STR_TO_DATE(?2, '%d/%m/%Y'))";

    public static final String BUSCAR_ULTIMOS_5_EVENTOS = "SELECT evento_id as idDoEvento, " +
            "evento_nome as nomeDoEvento, " +
            "evento_data as dataDoEvento " +
            "FROM tb_evento " +
            "ORDER BY evento_data DESC " +
            "LIMIT 5";

}
