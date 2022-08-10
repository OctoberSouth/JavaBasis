package com.lp.controller;

import com.lp.service.EsGpsDocumentService;
import com.lp.service.EsGpsIndexService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RequestMapping("/gps")
public class GpsController {

    @Resource
    private EsGpsIndexService esGpsIndexService;

    @Resource
    private EsGpsDocumentService esGpsDocumentService;

    @GetMapping("/test")
    public String test() throws IOException {

        boolean exist = esGpsIndexService.exists();
        if (!exist) {
            esGpsIndexService.create();
        }

        esGpsIndexService.query();

        //
        /*GpsInfo gps = new GpsInfo();
        gps.setId("1");
        gps.setDeviceId("1111");
        gps.setVehicleId("123");
        gps.setLocation("12,33");
        gps.setCreateTime(System.currentTimeMillis());
        gps.setGpsTime(System.currentTimeMillis());
        esGpsDocumentService.add(gps);*/

        /*List<GpsInfo> gpsList =  new ArrayList<>();
        int i= 0;
        GpsInfo gps = null;
        long time = 1656041715000L;
        while (i < 10000){
            gps = new GpsInfo();
            gps.setId(String.valueOf(i*10000));
            gps.setDeviceId("1111");
            gps.setVehicleId("123456");
            gps.setLocation("12233.2232,33.2512235");
            gps.setCreateTime(time);
            gps.setGpsTime(time);
            gpsList.add(gps);
            //
            time += 1000;
            i += 1;
        }
        esGpsDocumentService.bulk(gpsList);*/


        long start = 1656041715000L;
        long end = 1656041725000L;
        String v = "123456";
        esGpsDocumentService.search(v, start, end, 0, 20);


        return "elasticSearch test!!!!";
    }

}