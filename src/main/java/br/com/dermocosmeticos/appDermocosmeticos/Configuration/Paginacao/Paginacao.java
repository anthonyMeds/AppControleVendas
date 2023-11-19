package br.com.dermocosmeticos.appDermocosmeticos.Configuration.Paginacao;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

@JsonIgnoreProperties(
        value = {"pageable", "sort", "empty"},
        ignoreUnknown = true
)
public class Paginacao<T> extends PageImpl<T> {
    private static final long serialVersionUID = -4243450116557925893L;
    private final PageImpl<T> page;
    @JsonProperty("conteudo")
    private List<T> content;
    @JsonProperty("paginacao")
    private PaginacaoElementos paginacaoElementos;
    @JsonIgnore
    private int number;
    @JsonIgnore
    private int totalPages;
    @JsonIgnore
    private int size;
    @JsonIgnore
    private long totalElements;
    @JsonIgnore
    private int numberOfElements;

    @JsonCreator(
            mode = Mode.PROPERTIES
    )
    public Paginacao(List<T> content, int number, int size, Long totalElements) {
        super(content, PageRequest.of(number, size), totalElements);
        this.page = new PageImpl(content, PageRequest.of(number, size), totalElements);
    }

    @JsonCreator(
            mode = Mode.PROPERTIES
    )
    public Paginacao(Page<T> content) {
        super(content.getContent(), content.getPageable(), content.getTotalElements());
        this.page = new PageImpl(content.getContent(), content.getPageable(), content.getTotalElements());
        this.paginacaoElementos = new PaginacaoElementos(content.getNumber(), content.getTotalPages(), content.getSize(), content.getTotalElements(), content.getNumberOfElements(), content.hasContent(), content.hasPrevious(), content.hasNext(), content.isFirst(), content.isLast());
    }

    public List<T> getContent() {
        return this.content = this.page.getContent();
    }

    public int getNumber() {
        return this.number = this.page.getNumber();
    }

    public int getTotalPages() {
        return this.totalPages = this.page.getTotalPages();
    }

    public int getSize() {
        return this.size = this.page.getSize();
    }

    public long getTotalElements() {
        return this.totalElements = this.page.getTotalElements();
    }

    public int getNumberOfElements() {
        return this.numberOfElements = this.page.getNumberOfElements();
    }

    @JsonIgnore
    public boolean isFirst() {
        return this.page.isFirst();
    }

    @JsonIgnore
    public boolean isLast() {
        return this.page.isLast();
    }
}

