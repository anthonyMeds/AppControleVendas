package br.com.dermocosmeticos.appDermocosmeticos.Configuration.Paginacao;


import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class OrdenacaoPaginacaoUtil {
    public OrdenacaoPaginacaoUtil() {
    }

    public List<Sort.Order> ordenarPaginacao(String nomeCampoColuna, String tipoOrdenacao) {
        List<Sort.Order> ordenacaoList = new ArrayList();
        ordenacaoList.add(new Sort.Order(Direction.fromString(tipoOrdenacao), nomeCampoColuna));
        return ordenacaoList;
    }

    public List<Sort.Order> ordenarPaginacao(List<String> nomeCampoColuna, List<String> tipoOrdenacao) {
        List<Sort.Order> ordenacaoList = new ArrayList();

        for(int i = 0; i < nomeCampoColuna.size(); ++i) {
            while(tipoOrdenacao.size() < nomeCampoColuna.size()) {
                tipoOrdenacao.add(tipoOrdenacao.get(i));
            }

            ordenacaoList.add(new Sort.Order(Direction.fromString((String)tipoOrdenacao.get(i)), (String)nomeCampoColuna.get(i)));
        }

        return ordenacaoList;
    }
}

