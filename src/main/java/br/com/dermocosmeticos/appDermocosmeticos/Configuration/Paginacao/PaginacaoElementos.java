package br.com.dermocosmeticos.appDermocosmeticos.Configuration.Paginacao;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaginacaoElementos {
    @JsonProperty("pagina")
    private int number;
    @JsonProperty("totalDePaginas")
    private int totalPages;
    @JsonProperty("elementosPorPagina")
    private int size;
    @JsonProperty("totalDeElementos")
    private long totalElements;
    @JsonProperty("totalElementosDaPagina")
    private int numberOfElements;
    @JsonProperty("possuiConteudo")
    public boolean hasContent;
    @JsonProperty("anterior")
    public boolean hasPrevious;
    @JsonProperty("proxima")
    public boolean hasNext;
    @JsonProperty("primeira")
    public boolean isFirst;
    @JsonProperty("ultima")
    public boolean isLast;

    public PaginacaoElementos(final int number, final int totalPages, final int size, final long totalElements, final int numberOfElements, final boolean hasContent, final boolean hasPrevious, final boolean hasNext, final boolean isFirst, final boolean isLast) {
        this.number = number;
        this.totalPages = totalPages;
        this.size = size;
        this.totalElements = totalElements;
        this.numberOfElements = numberOfElements;
        this.hasContent = hasContent;
        this.hasPrevious = hasPrevious;
        this.hasNext = hasNext;
        this.isFirst = isFirst;
        this.isLast = isLast;
    }

    public PaginacaoElementos() {
    }
}
