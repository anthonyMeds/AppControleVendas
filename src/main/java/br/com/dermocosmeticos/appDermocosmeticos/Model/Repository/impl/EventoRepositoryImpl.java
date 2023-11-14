package br.com.dermocosmeticos.appDermocosmeticos.Model.Repository.impl;

public class EventoRepositoryImpl {

    public static final String BUSCAR_EVENTOS = "select evento_id as id, " +
            "evento_nome as nomeDoEvento, " +
            "evento_data as dataDoEvento " +
            "from tb_evento " +
            "where (?1 is null or evento_nome like '%'||?1||'%') or" +
            "(?2 is null or evento_data to_date(?2, 'dd/MM/yyyy'))";
    public static final String BUSCAR_ULTIMOS_5_EVENTOS = "SELECT evento_id as id, " +
            "evento_nome as nomeDoEvento, " +
            "evento_data as dataDoEvento " +
            "FROM tb_evento " +
            "ORDER BY evento_data DESC " +
            "LIMIT 5";

}
