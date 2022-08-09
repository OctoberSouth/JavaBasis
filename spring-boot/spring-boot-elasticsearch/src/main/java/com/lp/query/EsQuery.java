package com.lp.query;

import lombok.Data;

@Data
public class EsQuery {
    private String indexName;
    private String field;
    private String word;
    private Integer from;
    private Integer size;

    public Integer getSize() {
        return size==0?30:size;
    }
}
