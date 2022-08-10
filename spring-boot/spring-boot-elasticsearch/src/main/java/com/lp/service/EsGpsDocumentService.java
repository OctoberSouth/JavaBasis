package com.lp.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.transport.endpoints.BooleanResponse;
import com.lp.dto.GpsInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EsGpsDocumentService {

    @Resource
    private ElasticsearchClient client;


    /**
     * 插入document
     *
     * @throws IOException
     */
    public void add(GpsInfo gps) throws IOException {
        IndexResponse indexResponse = client.index(i -> i
                .index(EsGpsIndexService.INDEX_NAME)
                //设置id
                .id(gps.getId())
                //
                .document(gps));

    }

    /**
     * 更新Document
     *
     * @throws IOException
     */
    public void update(GpsInfo gps) throws IOException {
        UpdateResponse<GpsInfo> updateResponse = client.update(u -> u
                        .index(EsGpsIndexService.INDEX_NAME)
                        .id(gps.getId())
                        .doc(gps)
                , GpsInfo.class);
    }

    /**
     * 判断Document是否存在
     *
     * @throws IOException
     */
    public void exist(String id) throws IOException {
        BooleanResponse indexResponse = client.exists(e -> e.index(EsGpsIndexService.INDEX_NAME).id(id));
        System.out.println(indexResponse.value());
    }

    /**
     * 查询Document
     *
     * @throws IOException
     */
    public void get(String id) throws IOException {
        GetResponse<GpsInfo> getResponse = client.get(g -> g
                        .index(EsGpsIndexService.INDEX_NAME)
                        .id("1")
                , GpsInfo.class
        );
        System.out.println(getResponse.source());


    }

    /**
     * 删除Document
     *
     * @throws IOException
     */
    public void delete(String id) throws IOException {
        DeleteResponse deleteResponse = client.delete(d -> d
                .index(EsGpsIndexService.INDEX_NAME)
                .id("1")
        );
        System.out.println(deleteResponse.id());
    }

    /**
     * 批量插入Document
     *
     * @throws IOException
     */
    public void bulk(List<GpsInfo> gpsList) throws IOException {

        List<BulkOperation> bulkOperationArrayList = new ArrayList<>();
        //遍历添加到bulk中
        for (GpsInfo gps : gpsList) {
            bulkOperationArrayList.add(BulkOperation.of(o -> o.index(i -> i.document(gps).id(gps.getId()))));
            //bulkOperationArrayList.add(BulkOperation.of(x->x.create(d->d.document(gps).id(gps.getId()).index(EsGpsIndexService.INDEX_NAME))));
        }

        BulkResponse bulkResponse = client.bulk(b -> b.index(EsGpsIndexService.INDEX_NAME).operations(bulkOperationArrayList));

    }

    /**
     * 查询
     *
     * @throws IOException https://wenku.baidu.com/view/a8954a68862458fb770bf78a6529647d27283439.html
     */
    public void search(String vehicleId, long startTime, long endTime, int page, int pageSize) throws IOException {

        SearchResponse<GpsInfo> search = client.search(s -> s
                        .index(EsGpsIndexService.INDEX_NAME)
                        .query(q -> q
                                .bool(b -> b
                                        .filter(m -> m.term(t -> t.field("vehicleId").value(vehicleId)))
                                        .filter(f -> f.range(x -> x.field("gpsTime").gte(JsonData.of(startTime)).lte(JsonData.of(endTime))))
                                ))

                        //分页查询，从第0页开始查询20个document
                        .from(page)
                        .size(pageSize)
                //按时间降序排序
                //.sort(f->f.field(o->o.field("gpsTime").order(SortOrder.Desc)))
                , GpsInfo.class
        );
        for (Hit<GpsInfo> hit : search.hits().hits()) {
            System.out.println(hit.source());
        }
    }
}