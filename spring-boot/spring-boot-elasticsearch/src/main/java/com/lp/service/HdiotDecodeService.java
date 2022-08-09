package com.lp.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.CountResponse;
import com.lp.query.EsQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class HdiotDecodeService {

    @Resource
    private ElasticsearchClient client;


    public Long  getDecodeMsg() {
        EsQuery dto = new EsQuery();
        // decode_data  origin_data
        dto.setIndexName("decode_data");
        dto.setField("devid");
        dto.setWord("devid");
        return queryCountByFiled(client,dto);
    }

    private long queryCountByFiled(ElasticsearchClient client, EsQuery dto)  {
        CountResponse count = null;
        try {
            count = client.count(c -> c.index(dto.getIndexName()).query(q -> q.term(t -> t
                    .field(dto.getField())
                    .value(dto.getWord())
            )));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long total = count.count();
        return total;
    }

}
