package com.lp.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HdiotDecodeDTO {


    private String appid;

    private String pid;

    private String drvid;

    private String mapDevid;

    private String pcode;

    private String protocol;

    private String devid;

    private String sn;

    private String imei;

    private String messageId;

    private Object data;

    private String session;

    private LocalDateTime created;

    private LocalDateTime changed;

}