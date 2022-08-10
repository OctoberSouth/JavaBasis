package com.lp.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.indices.DeleteIndexResponse;
import co.elastic.clients.elasticsearch.indices.GetIndexResponse;
import co.elastic.clients.transport.endpoints.BooleanResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class EsGpsIndexService {

    @Resource
    private ElasticsearchClient client;


    public final static String INDEX_NAME = "gps";

    /**
     * 增加index
     *
     * @throws IOException
     */
    public boolean create() throws IOException {
        CreateIndexResponse indexResponse = client.indices().create(c -> c.index(INDEX_NAME));
        System.out.println(indexResponse.toString());
        return indexResponse.acknowledged();
    }


    /**
     * 查询Index
     *
     * @throws IOException
     */
    public void query() throws IOException {
        GetIndexResponse getIndexResponse = client.indices().get(i -> i.index(INDEX_NAME));
        System.out.println(getIndexResponse.toString());
    }

    /**
     * 判断index是否存在
     *
     * @throws IOException
     */
    public boolean exists() throws IOException {
        BooleanResponse booleanResponse = client.indices().exists(e -> e.index(INDEX_NAME));
        System.out.println(booleanResponse.value());
        return booleanResponse.value();
    }


    /**
     * 删除index
     *
     * @throws IOException
     */
    public void delete() throws IOException {
        DeleteIndexResponse deleteIndexResponse = client.indices().delete(d -> d.index(INDEX_NAME));
        System.out.println(deleteIndexResponse.toString());
    }

}
